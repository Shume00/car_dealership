package com.finki.car_dealership.service;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.Wishlist;

import java.util.List;

public interface WishlistService {

    List<Car> listAllCarsInWishlist(Long listId);
    Wishlist getWishlist(String username);
    Wishlist addCarToWishlist(String username, Long carId);
}
