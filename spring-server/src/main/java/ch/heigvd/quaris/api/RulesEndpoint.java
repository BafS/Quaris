package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.RulesApi;
import ch.heigvd.quaris.api.dto.RuleDTO;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.Rule;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.RuleRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fabien Salathe
 * @author Henrik Akesson
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

    /**
     * HTTP PUT handler. Updates a Rule
     * @param id : Rule id
     * @param data : Rule data to change
     * @return
     */
    @Override
    public ResponseEntity<Void> rulesIdPut(@ApiParam(value = "Rule id", required = true) @PathVariable("id") String id, @ApiParam(value = "new Rule data", required = true) @RequestBody RuleDTO data) {

        ch.heigvd.quaris.models.Rule rule = rulesRepository.findOne(Long.parseLong(id));

        // Check which attributes need to be changed
        try {
            if(data.getName() != null)
                rule.setName(data.getName());
            if(data.getEnabled() != null)
                rule.setEnabled(data.getEnabled());
            if(data.getAction() != null)
                rule.setAction(data.getAction());
            if(data.getCriteria() != null)
                rule.setCriteria(data.getCriteria());
            // Save badge
            rulesRepository.save(rule);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * HTTP POST Rule handler
     * @param rule : Rule to add
     * @return
     */
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
