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

    public boolean addBadge(final String identifier, final String badgeName) {
        System.out.println("[i] Add new badge to user " + identifier);

        EndUser endUser = getCurrentUser(identifier);

        String targetApplicationName = new ApplicationService().getCurrentApplicationName();
        Badge badge = badgeRepository.findByNameAndApplicationName(badgeName, targetApplicationName);

        if (endUser != null) {
            endUser.getBadges().add(badge);

            if (endUserRepository.save(endUser) != null) {
                new ElasticSearchService().addBadgeToElasticsearch(badge, targetApplicationName);

                return true;
            }
        }

        return false;
    }

    synchronized public boolean removeBadge(final String identifier, final String badgeName) {
        EndUser endUser = getCurrentUser(identifier);

        String targetApplicationName = new ApplicationService().getCurrentApplicationName();
        Badge badge = badgeRepository.findByNameAndApplicationName(badgeName, targetApplicationName);

        if (endUser != null) {
            endUser.getBadges().remove(badge);

            return endUserRepository.save(endUser) != null;
        }

        return false;
    }

    /**
     * Add (or substract) some points to a given scale
     *
     * @param identifier : username
     * @param scaleName : scale to add points to
     * @param pointsToAdd : number of points to add/remove
     */
    synchronized public boolean addToScale(final String identifier, final String scaleName, final int pointsToAdd) {
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
