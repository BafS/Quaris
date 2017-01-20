package ch.heigvd.quaris.models;

import java.io.Serializable;
import java.util.Date;
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

    @Column(nullable = false)
    private String idInApplication;

    private int numberOfEvents;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    //@ManyToMany //(targetEntity = Badge.class)
//    @JoinTable(
//            name="user_badges",
//            joinColumns=@JoinColumn(name="user_id"),
//            inverseJoinColumns=@JoinColumn(name="badge_id")
//    )
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_badges",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "badge_id")
//    )

    @ManyToMany
    private List<Badge> badges;

    @ManyToMany
    private List<Scale> scales;

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
