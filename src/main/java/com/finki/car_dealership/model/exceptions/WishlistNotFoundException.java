package com.finki.car_dealership.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WishlistNotFoundException extends RuntimeException{

    public WishlistNotFoundException(Long id) {
        super(String.format("Wishlist with id: %d was not found", id));
    }
}

