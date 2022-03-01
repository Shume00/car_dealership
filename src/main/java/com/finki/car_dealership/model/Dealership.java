package com.finki.car_dealership.model;

import javax.persistence.*;

@Entity
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    public Dealership(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Dealership() {

    }
}
