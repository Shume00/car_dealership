package com.finki.car_dealership.service;

import com.finki.car_dealership.model.CarBrand;

import java.util.List;

public interface CarBrandService {
    CarBrand create(String name, String description);

    CarBrand update(String name, String description);

    void delete(String name);

    List<CarBrand> listCategories();

    List<CarBrand> searchCategories(String searchText);
}
