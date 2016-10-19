package dev.valentinpichavant.beans;


import javax.persistence.*;

/**
 * Created by dev.valentinpichavant on 10/17/16.
 */

@Entity
@Table(name = "outlet")
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "outlet_activated")
    private Boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Outlet() {
        this.activated = null;
    }

    public Outlet(Boolean activated) {
        this.activated = activated;
    }
}
