package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Rule;
import ch.heigvd.quaris.models.Scale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Fabien Salathe
 */
@Repository
public interface RuleRepository extends CrudRepository<Rule, Long> {
    List<Rule> findByApplicationId(Long applicationId);

    List<Rule> findByApplicationName(String applicationName);
}
