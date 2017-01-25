package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.Badge;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.models.Point;
import ch.heigvd.quaris.models.Scale;
import ch.heigvd.quaris.repositories.BadgeRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.repositories.PointRepository;
import ch.heigvd.quaris.repositories.ScaleRepository;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Fabien Salathe on 23.01.17.
 */
public class EventScriptsProcessor {

    private final EndUserRepository endUserRepository;

    private final BadgeRepository badgeRepository;

    private final ScaleRepository scaleRepository;

    private final PointRepository pointRepository;

    public EventScriptsProcessor(EndUserRepository endUserRepository, BadgeRepository badgeRepository, ScaleRepository scaleRepository, PointRepository pointRepository) {
        this.endUserRepository = endUserRepository;
        this.badgeRepository = badgeRepository;
        this.scaleRepository = scaleRepository;
        this.pointRepository = pointRepository;
    }

    private EndUser getCurrentUser(final String identifier) {
        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        return endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, identifier);
    }

    public void addBadge(String identifier, String badgeName) {
        System.out.println("[i] Add new badge tu user " + identifier);

        EndUser endUser = getCurrentUser(identifier);

        String targetApplicationName = new ApplicationService().getCurrentApplicationName();
        Badge badge = badgeRepository.findByNameAndApplicationName(badgeName, targetApplicationName);

        if (endUser != null) {
//            if (!endUser.hasBadge(badge)) {
            endUser.getBadges().add(badge);

//            endUser.getBadges().forEach(b -> {
//                System.out.println(b.getName());
//            });

//            }

            if (endUserRepository.save(endUser) != null) {
                new ElasticSearchService().addBadgeToElasticsearch(badge, targetApplicationName);
            }
        }

        System.out.println("[i] Badge [" + badgeName + "] added to [" + identifier + "]!");
    }

    public void removeBadge(String badgeName) {

    }

    /**
     * Add (or substract) some points to a given scale
     *
     * @param identifier
     * @param scaleName
     * @param pointsToAdd
     */
    public boolean addToScale(final String identifier, final String scaleName, final int pointsToAdd) {
        System.out.println("addToScale::");
        EndUser endUser = getCurrentUser(identifier);

        if (endUser != null) {
            String targetApplicationName = new ApplicationService().getCurrentApplicationName();

            Scale scale = scaleRepository.findByNameAndApplicationName(scaleName, targetApplicationName);
//            Point pointUser = scaleRepository.findByNameAndApplicationName(scaleName, targetApplicationName);

            if (scale != null) {
                EndUser enduser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, identifier);

                if (endUser.getPoint(scaleName) == null) {
                    Point newPoint = new Point();
                    newPoint.setPoints(0);
                    newPoint.setScale(scale);
                    newPoint.setEndUser(endUser);
                    HashSet<Point> newPoints = new HashSet<>();
                    newPoints.add(newPoint);

                    if (pointRepository.save(newPoints) != null) {
                        enduser.setPoint(newPoints);
                    }
                }

                Stream<Point> newUserPoints = enduser.getPoint().parallelStream().map(p -> {
                    if (p.getScale().getName().equals(scaleName)) {
                        p.addPoints(pointsToAdd);
                    }

                    return p;
                });

                endUser.setPoint(newUserPoints.collect(Collectors.toSet()));

                endUserRepository.save(enduser);

                return true;
            }
        }

        return false;
    }
}
