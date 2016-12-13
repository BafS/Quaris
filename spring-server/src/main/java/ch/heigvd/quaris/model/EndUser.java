package ch.heigvd.quaris.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class EndUser implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @ManyToOne
  private Application application;
  
  private String idInGamifiedApplication;
  
  private int numberOfEvents;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public String getIdInGamifiedApplication() {
    return idInGamifiedApplication;
  }

  public void setIdInGamifiedApplication(String idInGamifiedApplication) {
    this.idInGamifiedApplication = idInGamifiedApplication;
  }

  public int getNumberOfEvents() {
    return numberOfEvents;
  }

  public void setNumberOfEvents(int numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
  }
  
}
