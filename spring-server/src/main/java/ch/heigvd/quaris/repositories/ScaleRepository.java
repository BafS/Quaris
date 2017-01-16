package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Scale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface ScaleRepository extends CrudRepository<Scale, Long> {
}
