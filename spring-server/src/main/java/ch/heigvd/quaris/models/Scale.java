package ch.heigvd.quaris.models;

import javax.persistence.*;

/**
 * Created by Fabien Salathe on 16.01.17.
 */
@Entity
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Application application;

    private String name;

    private long points;
}
