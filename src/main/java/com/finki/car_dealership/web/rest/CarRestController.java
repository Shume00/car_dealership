package com.finki.car_dealership.web.rest;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.dto.CarDto;
import com.finki.car_dealership.model.service.CarService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cars")

public class CarRestController {

    private final CarService carService;


    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    private List<Car> findAll() {return this.carService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        return this.carService.findById(id)
                .map(car -> ResponseEntity.ok().body(car))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.carService.deleteById(id);
        if(this.carService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
