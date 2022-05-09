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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d"+location;
    }

    public Dealership(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Dealership() {

    }
}
