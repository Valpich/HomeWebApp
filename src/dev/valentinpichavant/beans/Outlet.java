package dev.valentinpichavant.beans;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by dev.valentinpichavant on 10/17/16.
 */
@Component
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Boolean activated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Outlet() {
        this.activated = null;
    }

    public Outlet(Boolean activated) {
        this.activated = activated;
    }
}
