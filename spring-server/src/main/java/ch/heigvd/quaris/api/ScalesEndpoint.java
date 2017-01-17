package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.ScalesApi;
import ch.heigvd.quaris.api.dto.Scale;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.ScaleRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Fabien Salathe
 */
@RestController
public class ScalesEndpoint implements ScalesApi {

    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Autowired
    private final ScaleRepository scalesRepository = null;

    @Override
    public ResponseEntity<List<Scale>> scalesGet() {
        ApplicationService as = new ApplicationService();
        List<ch.heigvd.quaris.models.Scale> all = scalesRepository.findByApplicationName(as.getCurrentApplicationName());

        List<Scale> dtos = all.parallelStream().map(sm -> {
            Scale s = new Scale();
            s.setName(sm.getName());
            s.setDescription(sm.getDescription());
            return s;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<Void> scalesPost(@ApiParam(value = "Scale to add", required = true) @RequestBody Scale scale) {
        ApplicationService as = new ApplicationService();
        Application app = applicationsRepository.findByName(as.getCurrentApplicationName());

        if (app == null) {
            return ResponseEntity.notFound().build();
        }

        ch.heigvd.quaris.models.Scale scaleModel = new ch.heigvd.quaris.models.Scale();
        scaleModel.setApplication(app);
        scaleModel.setName(scale.getName());
        scaleModel.setDescription(scale.getDescription());
        scaleModel.setPoints(0);

        if (scalesRepository.save(scaleModel) == null) {
            // Todo -> if duplicate
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
