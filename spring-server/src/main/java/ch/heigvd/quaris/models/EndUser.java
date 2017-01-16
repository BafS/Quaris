package ch.heigvd.quaris.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @author Olivier Liechti
 */
@Entity
@Table(name = "user")
public class EndUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Application application;

    private String idInApplication;

    private int numberOfEvents;

    @ManyToMany
    @JoinTable(
            name="user_badge",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="badge_id", referencedColumnName="id")
    )
    private List<Badge> projects;

    public long getId() {
        return id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getIdInGamifiedApplication() {
        return idInApplication;
    }

    public void setIdInGamifiedApplication(String idInApplication) {
        this.idInApplication = idInApplication;
    }

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setNumberOfEvents(int numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }

}
