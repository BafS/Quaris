package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.RulesApi;
import ch.heigvd.quaris.api.dto.Rule;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.RuleRepository;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String targetApplicationName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            targetApplicationName = authentication.getName();
        }

        Application targetApplication = applicationsRepository.findByName(targetApplicationName);

        Iterable<ch.heigvd.quaris.models.Rule> allRules = rulesRepository.findAll();

        return ResponseEntity.ok(allRules);

        // return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> rulesPost(@ApiParam(value = "Rule to add", required = true) @RequestBody Rule rule) {
        return null;
    }
}
