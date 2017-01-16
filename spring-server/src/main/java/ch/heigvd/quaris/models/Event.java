package ch.heigvd.quaris.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fabien Salathe
 */
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private EndUser user; // Identifier

    @OneToOne
    private Application app;

    private String type;

    // @Column
    // private String payload;

    public long getId() {
        return id;
    }

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

    //    public String getPayload() {
//        return payload;
//    }
//
//    public void setPayload(String payload) {
//        this.payload = payload;
//    }
}
