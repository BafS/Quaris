package ch.heigvd.quaris.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * @author Fabien Salathe & Henrik Akesson
 */
@Entity
@Table
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

    @Column(unique = true, nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "end_user_badge",
//            joinColumns = {@JoinColumn(name = "end_user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "badge_id")}
//    )
    private List<Badge> badge;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Scale> scale;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }

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

    public String getIdInApplication() {
        return idInApplication;
    }

    public void setIdInApplication(String idInApplication) {
        this.idInApplication = idInApplication;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Badge> getBadges() {
        return badge;
    }

    public void setBadges(List<Badge> badges) {
        this.badge = badges;
    }

    public List<Scale> getScales() {
        return scale;
    }

    public void setScales(List<Scale> scales) {
        this.scale = scales;
    }
}
