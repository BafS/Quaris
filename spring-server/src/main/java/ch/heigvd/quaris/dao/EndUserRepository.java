package ch.heigvd.quaris.dao;

import ch.heigvd.quaris.model.EndUser;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public interface EndUserRepository extends CrudRepository<EndUser, Long>{

  public EndUser findByApplicationNameAndIdInGamifiedApplication(String targetApplicationName, String targetEndUserId);
  
}
