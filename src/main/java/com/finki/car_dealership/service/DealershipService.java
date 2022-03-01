package com.finki.car_dealership.service;

import com.finki.car_dealership.model.Dealership;

import java.util.List;
import java.util.Optional;

public interface DealershipService {

    Optional<Dealership> findById(Long id);
    List<Dealership> findAll();
    Optional<Dealership> save(String name, String location);
    void deleteById(Long id);
}
