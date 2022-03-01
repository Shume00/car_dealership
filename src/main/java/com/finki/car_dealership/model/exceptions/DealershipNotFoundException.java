package com.finki.car_dealership.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DealershipNotFoundException extends RuntimeException{

    public DealershipNotFoundException(Long id) {
        super(String.format("Dealership with id: %d was not found", id));
    }
}

