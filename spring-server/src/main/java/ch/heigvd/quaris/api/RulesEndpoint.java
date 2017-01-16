package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.RulesApi;
import ch.heigvd.quaris.api.dto.Rule;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.RuleRepository;
import ch.heigvd.quaris.services.ApplicationService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
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

        Iterable<ch.heigvd.quaris.models.Rule> allRules = rulesRepository.findByApplicationName(as.getCurrentApplicationName());

        return ResponseEntity.ok(allRules);
    }

    @Override
    public ResponseEntity<Void> rulesPost(@ApiParam(value = "Rule to add", required = true) @RequestBody Rule rule) {
        if (rule == null) {
            return ResponseEntity.badRequest().build();
        }

        ApplicationService as = new ApplicationService();

        Application app = applicationsRepository.findByName(as.getCurrentApplicationName());
        System.out.println("targetApplicationName: " + app.getName()); // DEBUG

        ch.heigvd.quaris.models.Rule ruleModel = new ch.heigvd.quaris.models.Rule();
        ruleModel.setName(rule.getName());
        ruleModel.setAction(rule.getAction());
        ruleModel.setApplication(app);
//        ruleModel.setEnabled(rule.getEnabled());
        // TODO condition

        rulesRepository.save(ruleModel);

        return ResponseEntity.ok().build();
    }
}
