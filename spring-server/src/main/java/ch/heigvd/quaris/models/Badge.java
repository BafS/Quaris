package ch.heigvd.quaris.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Fabien Salathe on 16.01.17.
 */
@Entity
public class Badge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Application application;

    private String name;

    private String description;

    // private String icon; // byte[] ?
}
