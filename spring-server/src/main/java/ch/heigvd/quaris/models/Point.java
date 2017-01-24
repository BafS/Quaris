package ch.heigvd.quaris.models;

import javax.persistence.*;

/**
 * Created by Fabien Salathe on 23.01.17.
 */
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long points;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_user_id")
    private EndUser endUser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scale_id")
    private Scale scale;

    public long getPoints() {
        return points;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public void addPoints(long delta) {
        this.points += delta;
    }

    public EndUser getEndUser() {
        return endUser;
    }

    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }
}
