package com.finki.car_dealership.model.service;

import com.finki.car_dealership.model.CarBrand;
import com.finki.car_dealership.model.Dealership;

import java.util.List;
import java.util.Optional;

public interface CarBrandService {
    CarBrand create(String name, String description);

    CarBrand update(String name, String description);

    void delete(String name);

    List<CarBrand> listCarBrands();

    List<CarBrand> searchCarBrands(String searchText);

    CarBrand findById(Long id);
}
