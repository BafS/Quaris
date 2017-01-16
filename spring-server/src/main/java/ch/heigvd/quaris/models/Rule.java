package ch.heigvd.quaris.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fabien Salathe
 */
@Entity
public class Rule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Application application;
}
