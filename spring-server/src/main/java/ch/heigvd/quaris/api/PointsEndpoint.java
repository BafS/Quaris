package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.PointsApi;
import ch.heigvd.quaris.api.dto.Point;
import ch.heigvd.quaris.api.dto.Scale;
import ch.heigvd.quaris.api.dto.User;
import ch.heigvd.quaris.models.EndUser;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class PointsEndpoint implements PointsApi {

    @Autowired
    private final EndUserRepository endUserRepository = null;

    @Autowired
    private final PointRepository pointRepository = null;

    @Override
    public ResponseEntity<List<Point>> pointsGet() {
        return null;
    }

    @Override
    public ResponseEntity<List<Point>> pointsIdentifierGet(@ApiParam(value = "Identifier", required = true) @PathVariable("identifier") String identifier) {
        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        EndUser endUser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, identifier);

        Set<ch.heigvd.quaris.models.Point> userPoints = endUser.getPoint();

        List<Point> userPointsDTO = new ArrayList<>();

        userPoints.forEach(p -> {
            Point pointDTO = new Point();
            pointDTO.setScale(new ModelMapper().map(p.getScale(), Scale.class));
            pointDTO.setPoint((int) p.getPoints());
            pointDTO.setUser(new ModelMapper().map(endUser, User.class));

            userPointsDTO.add(pointDTO);
        });

        return ResponseEntity.ok(userPointsDTO);
    }
}
