package ch.heigvd.quaris.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Fabien Salathe on 16.01.17.
 */
@Entity
public class Badge implements Serializable {
    @Version
    private int version;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Application application;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "badge")
    private List<EndUser> end_user;

    @Column(nullable = false)
    private String name;

    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // private String icon; // byte[] ?
}
