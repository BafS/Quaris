package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.PointsApi;
import ch.heigvd.quaris.api.dto.PointDTO;
import ch.heigvd.quaris.api.dto.ScaleDTO;
import ch.heigvd.quaris.api.dto.UserDTO;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.models.Point;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.repositories.PointRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Fabien Salathe
 * @author Henrik Akesson
 */
@RestController
public class PointsEndpoint implements PointsApi {

    @Autowired
    private final EndUserRepository endUserRepository = null;

    @Autowired
    private final PointRepository pointRepository = null;

    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Override
    public ResponseEntity<List<PointDTO>> pointsGet() {
        // All apps
        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        Application app = applicationsRepository.findByName(targetApplicationName);

        if (app != null) {
            List<Point> topPoints = pointRepository.findAllByOrderByPointsDesc();

            List<PointDTO> usersPointsDTO = new ArrayList<>();

            topPoints.forEach(p -> {
                PointDTO pointDTO = new PointDTO();
                pointDTO.setScale(new ModelMapper().map(p.getScale(), ScaleDTO.class));
                pointDTO.setPoint((int) p.getPoints());
                pointDTO.setUser(new ModelMapper().map(p.getEndUser(), UserDTO.class));

                usersPointsDTO.add(pointDTO);
            });

            return ResponseEntity.ok(usersPointsDTO);
        }

        return null;
    }

    @Override
    public ResponseEntity<List<PointDTO>> pointsIdentifierGet(@ApiParam(value = "Identifier", required = true) @PathVariable("identifier") String identifier) {
        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        EndUser endUser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, identifier);

        Set<Point> userPoints = endUser.getPoint();

        List<PointDTO> userPointsDTO = new ArrayList<>();

        userPoints.forEach(p -> {
            PointDTO pointDTO = new PointDTO();
            pointDTO.setScale(new ModelMapper().map(p.getScale(), ScaleDTO.class));
            pointDTO.setPoint((int) p.getPoints());
            pointDTO.setUser(new ModelMapper().map(endUser, UserDTO.class));

            userPointsDTO.add(pointDTO);
        });

        return ResponseEntity.ok(userPointsDTO);
    }
}
