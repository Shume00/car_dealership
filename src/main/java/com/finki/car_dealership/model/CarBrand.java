package com.finki.car_dealership.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CarBrand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String description;

    public CarBrand() {

    }

}
