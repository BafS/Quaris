package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch), Fabien Salathe, Henrik Akesson
 */
@Repository
public interface EndUserRepository extends CrudRepository<EndUser, Long> {
    EndUser findByApplicationNameAndIdInApplication(String targetApplicationName, String targetEndUserId);

    List<EndUser> findByApplicationName(String targetApplicationName);
}
