package ch.heigvd.quaris.models;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Fabien Salathe
 */
public class Event implements Serializable {

    private EndUser user; // Identifier

    private String identifier;

    private Application app;

    private String type;

    private DateTime timestamp;

    private Object payload;

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

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
