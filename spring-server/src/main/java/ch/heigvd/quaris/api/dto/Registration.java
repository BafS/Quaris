package ch.heigvd.quaris.api.dto;

/**
 * Created by Fabien Salathe on 13.12.16.
 */
public class Registration {

    private String applicationName;
    private String hashedPassword;

    public String getApplicationName() {
        return applicationName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
