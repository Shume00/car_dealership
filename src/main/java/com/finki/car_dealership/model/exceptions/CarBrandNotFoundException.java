package com.finki.car_dealership.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarBrandNotFoundException extends RuntimeException{
    public CarBrandNotFoundException(Long id) {
        super(String.format("Car brand with id: %d is not found", id));
    }
}

