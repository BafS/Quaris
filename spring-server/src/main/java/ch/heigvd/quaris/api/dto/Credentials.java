package ch.heigvd.quaris.api.dto;

/**
 * Created by Fabien Salathe on 13.12.16.
 */
public class Credentials {
    private String applicationName;
    private String password;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
