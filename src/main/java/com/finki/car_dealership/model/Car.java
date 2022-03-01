package com.finki.car_dealership.model;

import javax.persistence.*;

@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private Long year;
    private Long price;

    @ManyToOne
    private Dealership dealership;

    @ManyToOne
    private CarBrand carBrand;

    public Car(String model, Long year, Dealership dealership, CarBrand carBrand, Long price) {
        this.model = model;
        this.year = year;
        this.price=price;
        this.dealership = dealership;
        this.carBrand = carBrand;
    }

    public Car() {

    }
}
