package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface BadgeRepository extends CrudRepository<Badge, Long> {
    public List<Badge> findByApplicationId(Long applicationId);

    public List<Badge> findByApplicationName(String applicationName);

    public Badge findByNameAndApplicationName(String badgeName, String applicationName);
}
