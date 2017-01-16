package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Badge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface BadgeRepository extends CrudRepository<Badge, Long> {
}
