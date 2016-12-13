package ch.heigvd.quaris.api.dto;

/**
 * @author Fabien Salathe
 */
public class User {
    private int numberOfEvents;
    private String userId;

    public int getNumberOfEvents() {
        return numberOfEvents;
    }

    public void setNumberOfEvents(int numberOfEvents) {
        this.numberOfEvents = numberOfEvents;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
