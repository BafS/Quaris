package ch.heigvd.quaris.models;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fabien Salathe
 */
// @Entity
public class Event implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

//    @ManyToOne
    private EndUser user; // Identifier

    private String identifier;

//    @OneToOne
    private Application app;

    private String type;

    // @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;

    // @Column
    // private String payload;

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    //    public String getPayload() {
//        return payload;
//    }
//
//    public void setPayload(String payload) {
//        this.payload = payload;
//    }
}
