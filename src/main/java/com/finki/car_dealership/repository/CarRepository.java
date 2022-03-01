package com.finki.car_dealership.repository;

import com.finki.car_dealership.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findCarByYearAfter(Long year);
}
