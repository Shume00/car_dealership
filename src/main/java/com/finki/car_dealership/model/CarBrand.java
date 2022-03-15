package com.finki.car_dealership.model;

import javax.persistence.*;

@Entity
@Table(name = "carbrand")
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
