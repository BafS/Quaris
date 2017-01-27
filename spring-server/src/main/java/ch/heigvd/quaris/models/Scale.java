package ch.heigvd.quaris.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fabien Salathe on 16.01.17.
 */
@Entity
public class Scale {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Application application;

    @Column(unique = true, nullable = false)
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//, mappedBy = "scale")
//    private List<Point> point;

    @OneToMany(mappedBy = "scale")
    private Set<Point> point = new HashSet<>();


    private String description;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
