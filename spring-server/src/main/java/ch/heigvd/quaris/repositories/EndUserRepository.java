package ch.heigvd.quaris.repositories;

import ch.heigvd.quaris.models.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Repository
public interface EndUserRepository extends CrudRepository<EndUser, Long>{

    public EndUser findByApplicationNameAndIdInApplication(String targetApplicationName, String targetEndUserId);
  
}
