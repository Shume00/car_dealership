package com.finki.car_dealership.service.impl;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.CarBrand;
import com.finki.car_dealership.model.Dealership;
import com.finki.car_dealership.model.exceptions.CarBrandNotFoundException;
import com.finki.car_dealership.model.exceptions.DealershipNotFoundException;
import com.finki.car_dealership.repository.CarBrandRepository;
import com.finki.car_dealership.repository.CarRepository;
import com.finki.car_dealership.repository.DealershipRepository;
import com.finki.car_dealership.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarBrandRepository carBrandRepository;
    private final DealershipRepository dealershipRepository;
    private final CarRepository carRepository;

    public CarServiceImpl(CarBrandRepository carBrandRepository, DealershipRepository dealershipRepository, CarRepository carRepository) {
        this.carBrandRepository = carBrandRepository;
        this.dealershipRepository = dealershipRepository;
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return this.carRepository.findById(id);
    }

    @Override
    public Optional<Car> findByModel(String model) {
        return this.carBrandRepository.findByModel(model);
    }

    @Override
    @Transactional
    public Car save(String model, Long year, Long dealershipId, Long carBrandId, Long price) {
        Dealership dealership = dealershipRepository.findById(dealershipId).orElseThrow(()-> new DealershipNotFoundException(dealershipId));
        CarBrand carBrand = carBrandRepository.findById(carBrandId).orElseThrow(()-> new CarBrandNotFoundException(carBrandId));
        return this.carRepository.save(new Car(model, year, dealership, carBrand, price));
    }
//String model, Long year, Dealership dealership, CarBrand carBrand, Long price
    @Override
    @Transactional
    public Car edit(Long id, String model, Long year, Long dealershipId, Long carBrandId, Long price) {

        Car car= this.carRepository.findById(id).orElseThrow(() -> new CarBrandNotFoundException(id));

        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);

        CarBrand carBrand = this.carBrandRepository.findById(carBrandId)
                .orElseThrow(() -> new CarBrandNotFoundException(carBrandId));
        car.setCarBrand(carBrand);

        Dealership dealership = this.dealershipRepository.findById(dealershipId)
                .orElseThrow(() -> new DealershipNotFoundException(dealershipId));
        car.setDealership(dealership);

        return this.carRepository.save(car);
    }


    @Override
    public void deleteById(Long id) {
        this.carRepository.deleteById(id);
    }
}
