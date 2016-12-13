package ch.heigvd.quaris.dao;

import ch.heigvd.quaris.model.Application;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public interface ApplicationRepository extends CrudRepository<Application, Long> {
  
  public Application findByName(String name);

}
