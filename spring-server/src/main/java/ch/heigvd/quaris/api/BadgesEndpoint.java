package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.BadgesApi;
import ch.heigvd.quaris.api.dto.BadgeDTO;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.Badge;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.BadgeRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Henrik on 17-Jan-17.
 */
@RestController
public class BadgesEndpoint implements BadgesApi {
    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Autowired
    private final BadgeRepository badgeRepository = null;


    @Transactional
    @Override
    public ResponseEntity<Void> badgesPost(@ApiParam(value = "Badge to add", required = true) @RequestBody BadgeDTO badgeDTO) {
        if (badgeDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        ApplicationService as = new ApplicationService();

        Application app = applicationsRepository.findByName(as.getCurrentApplicationName());

        // Set new badge attributes
        ch.heigvd.quaris.models.Badge badgeModel = new ch.heigvd.quaris.models.Badge();
        badgeModel.setName(badgeDTO.getName());
        badgeModel.setDescription(badgeDTO.getDescription());
        badgeModel.setApplication(app);

        if (badgeRepository != null) {
            try {
                badgeRepository.save(badgeModel);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<BadgeDTO> badgesBadgenameGet(@ApiParam(value = "A specific Badge's name", required = true) @PathVariable("badgename") String badgename) {
        ApplicationService as = new ApplicationService();
        Badge badgeModel = badgeRepository.findByNameAndApplicationName(badgename, as.getCurrentApplicationName());

        // If badge exists
        if (badgeModel != null) {
            ModelMapper modelMapper = new ModelMapper();
            BadgeDTO badgeDTO = modelMapper.map(badgeModel, BadgeDTO.class);
            return ResponseEntity.ok(badgeDTO);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity badgesGet() {
        ApplicationService as = new ApplicationService();

        Iterable<Badge> allBadges = badgeRepository.findByApplicationName(as.getCurrentApplicationName());

        return ResponseEntity.ok(allBadges);
    }

}
