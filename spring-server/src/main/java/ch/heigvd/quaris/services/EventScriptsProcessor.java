package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.Badge;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.models.Scale;
import ch.heigvd.quaris.repositories.BadgeRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.repositories.ScaleRepository;

import java.util.List;

/**
 * Created by Fabien Salathe on 23.01.17.
 */
public class EventScriptsProcessor {

    private final EndUserRepository endUserRepository;

    private final BadgeRepository badgeRepository;

    private final ScaleRepository scaleRepository;

    public EventScriptsProcessor(EndUserRepository endUserRepository, BadgeRepository badgeRepository, ScaleRepository scaleRepository) {
        this.endUserRepository = endUserRepository;
        this.badgeRepository = badgeRepository;
        this.scaleRepository = scaleRepository;
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
            endUserRepository.save(endUser);
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
     * @param points
     */
    public boolean addToScale(final String identifier, final String scaleName, final int points) {
        EndUser endUser = getCurrentUser(identifier);

        if (endUser != null) {
            String targetApplicationName = new ApplicationService().getCurrentApplicationName();

            Scale scale = scaleRepository.findByNameAndApplicationName(scaleName, targetApplicationName);

            if (scale != null) {
                // scale.addPoints(points);

                List<Scale> userScales = endUser.getScales();



                // ruleRepository.save(scale);

                return true;
            }
        }

        return false;
    }
}
