package com.finki.car_dealership.service;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.CarBrand;
import com.finki.car_dealership.model.Dealership;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAll();

    Optional<Car> findById(Long id);

    Optional<Car> findByModel(String model);

    Optional<Car> save(String model, Long year, Long dealership, Long carBrand, Long price);

    Optional<Car> edit(Long id, String model, Long year, Long dealership, Long carBrand, Long price);

    void deleteById(Long id);
}
