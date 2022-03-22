package com.finki.car_dealership.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Car> cars;


    public Wishlist(User user) {
        this.user = user;
        this.cars = new ArrayList<>();
    }

    public Wishlist() {

    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Car> getCars() {
        return cars;
    }
}
