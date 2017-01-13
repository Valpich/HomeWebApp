package dev.valentinpichavant.beans;


import javax.persistence.*;

/**
 * Created by dev.valentinpichavant on 10/17/16.
 */

@Entity
@Table(name = "outlet")
public class Outlet extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "outlet_activated")
    private Boolean activated;

    @Column(name = "outlet_number_on")
    private int numberOn;

    @Column(name = "outlet_number_off")
    private int numberOff;

    @Column(name = "outlet_description")
    private String description;

    @Override
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

    public int getNumberOn() {
        return numberOn;
    }

    public void setNumberOn(int number) {
        this.numberOn = number;
    }

    public int getNumberOff() {
        return numberOff;
    }

    public void setNumberOff(int number) {
        this.numberOff = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Outlet{" +
                "id=" + id +
                ", activated=" + activated +
                ", numberOn=" + numberOn +
                ", numberOff=" + numberOff +
                ", description='" + description + '\'' +
                '}';
    }
}
