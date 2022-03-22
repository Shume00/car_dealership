package com.finki.car_dealership.model.dto;

import lombok.Data;


@Data
public class CarDto {

    private String model;
    private Long year;
    private Long price;

    private Long CarBrand;
    private Long Dealership;

    public CarDto() {
    }

    public CarDto(String model, Long year, Long price, Long carBrand, Long dealership) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.CarBrand = carBrand;
        this.Dealership = dealership;
    }
}
