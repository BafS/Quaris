package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.RulesApi;
import ch.heigvd.quaris.api.dto.RuleDTO;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.RuleRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fabien Salathe
 */
@RestController
public class RulesEndpoint implements RulesApi {

    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Autowired
    private final RuleRepository rulesRepository = null;

    // public ResponseEntity<List<Rule>> rulesGet() {
    @Override
    public ResponseEntity rulesGet() {
        ApplicationService as = new ApplicationService();

        List<ch.heigvd.quaris.models.Rule> allRulesModel = rulesRepository.findByApplicationName(as.getCurrentApplicationName());

        // Create DTOs
        Stream<RuleDTO> allRulesDTO = allRulesModel
                .parallelStream()
                .map(rm -> new ModelMapper().map(rm, RuleDTO.class));

        return ResponseEntity.ok(allRulesDTO.collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Void> rulesPost(@ApiParam(value = "Rule to add", required = true) @RequestBody RuleDTO rule) {
        if (rule == null) {
            return ResponseEntity.badRequest().build();
        }

        ApplicationService as = new ApplicationService();

        Application app = applicationsRepository.findByName(as.getCurrentApplicationName());
        System.out.println("targetApplicationName: " + app.getName()); // DEBUG
        try {
            ch.heigvd.quaris.models.Rule ruleModel = new ch.heigvd.quaris.models.Rule();
            ruleModel.setName(rule.getName());
            ruleModel.setAction(rule.getAction());
            ruleModel.setApplication(app);
            ruleModel.setCriteria(rule.getCriteria());
            ruleModel.setEnabled(rule.getEnabled());

            rulesRepository.save(ruleModel);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok().build();
    }
}
