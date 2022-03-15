package com.finki.car_dealership.model;

import javax.persistence.*;

@Entity
@Table (name = "dealership")
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    public Dealership(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Dealership() {

    }
}
