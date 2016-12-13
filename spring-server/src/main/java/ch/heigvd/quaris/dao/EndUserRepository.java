package ch.heigvd.quaris.dao;

import ch.heigvd.quaris.model.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
//@Repository
public interface EndUserRepository extends CrudRepository<EndUser, Long>{

  public EndUser findByApplicationNameAndIdInApplication(String targetApplicationName, String targetEndUserId);
  
}
