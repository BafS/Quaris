package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.BadgesApi;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.api.dto.Badge;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.BadgeRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


/**
 * Created by Henrik on 17-Jan-17.
 */
@RestController
public class BadgesEndpoint implements BadgesApi {
    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Autowired
    private final BadgeRepository badgeRepository = null;

    @Override
    public ResponseEntity<Void> badgesPost(@ApiParam(value = "Badge to add", required = true) @RequestBody Badge badgeDTO) {
        if (badgeDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        ApplicationService as = new ApplicationService();

        Application app = applicationsRepository.findByName(as.getCurrentApplicationName());

        ch.heigvd.quaris.models.Badge badgeModel = new ch.heigvd.quaris.models.Badge();
        badgeModel.setName(badgeDTO.getName());
        badgeModel.setDescription(badgeDTO.getDescription());
        badgeModel.setApplication(app);

        if (badgeRepository != null) {
            badgeRepository.save(badgeModel);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @Override
    public ResponseEntity<Badge> badgesBadgenameGet(@ApiParam(value = "A specific Badge's name", required = true) @PathVariable("badgename") String badgename) {
        ApplicationService as = new ApplicationService();

        // TODO -> SQL
        List<ch.heigvd.quaris.models.Badge> allBadges = badgeRepository.findByApplicationName(as.getCurrentApplicationName());
        Optional<ch.heigvd.quaris.models.Badge> optionalBadgeToReturn = allBadges
                .stream()
                .filter(badge -> badge.getName().equals(badgename))
                .findFirst();

        Badge badgeDTO = new Badge();
        if (optionalBadgeToReturn.isPresent()) {
            badgeDTO.setName(optionalBadgeToReturn.get().getName());
            badgeDTO.setDescription(optionalBadgeToReturn.get().getDescription());
            return ResponseEntity.ok(badgeDTO);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity badgesGet() {
        ApplicationService as = new ApplicationService();

        Iterable<ch.heigvd.quaris.models.Badge> allBadges = badgeRepository.findByApplicationName(as.getCurrentApplicationName());

        return ResponseEntity.ok(allBadges);
    }

}
