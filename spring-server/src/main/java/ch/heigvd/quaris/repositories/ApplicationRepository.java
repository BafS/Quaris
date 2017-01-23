package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    Application findByName(String name);
}
