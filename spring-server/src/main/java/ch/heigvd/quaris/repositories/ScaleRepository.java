package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Scale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@Repository
public interface ScaleRepository extends CrudRepository<Scale, Long> {
    List<Scale> findByApplicationName(String applicationName);

    Scale findByNameAndApplicationName(String scaleName, String targetApplicationName);
}
