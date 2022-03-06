package com.finki.car_dealership.service.impl;

import com.finki.car_dealership.model.CarBrand;
import com.finki.car_dealership.model.exceptions.CarBrandNotFoundException;
import com.finki.car_dealership.repository.CarBrandRepository;
import com.finki.car_dealership.service.CarBrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }


    @Override
    public CarBrand create(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        CarBrand c = new CarBrand(name,description);
        carBrandRepository.save(c);
        return c;
    }

    @Override
    public CarBrand update(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        CarBrand c= new CarBrand(name,description);
        carBrandRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        carBrandRepository.deleteByName(name);
    }

    @Override
    public List<CarBrand> listCategories() {
        return carBrandRepository.findAll();
    }

    @Override
    public List<CarBrand> searchCategories(String searchText) {
        return carBrandRepository.findAllByNameLike(searchText);
    }

    @Override
    public CarBrand findById(Long id) {
        return this.carBrandRepository.findById(id).orElseThrow(()-> new CarBrandNotFoundException(id));
    }
}

