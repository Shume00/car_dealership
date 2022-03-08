package com.finki.car_dealership.repository;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    void deleteByName(String name);

    List<CarBrand> findAllByNameLike(String searchText);


}

