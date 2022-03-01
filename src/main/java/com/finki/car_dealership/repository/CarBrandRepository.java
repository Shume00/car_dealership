package com.finki.car_dealership.repository;

import com.finki.car_dealership.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
}

