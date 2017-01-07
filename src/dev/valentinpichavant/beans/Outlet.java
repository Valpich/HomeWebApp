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

    @Column(name = "outlet_number")
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
