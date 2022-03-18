package com.finki.car_dealership.model.service.impl;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.Wishlist;
import com.finki.car_dealership.repository.CarRepository;
import com.finki.car_dealership.repository.UserRepository;
import com.finki.car_dealership.repository.WishlistRepository;
import com.finki.car_dealership.model.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, UserRepository userRepository, CarRepository carRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> listAllCarsInWishlist(Long listId) {
        return null;
    }

    @Override
    public Wishlist getWishlist(String username) {
        return null;
    }

    @Override
    public Wishlist addCarToWishlist(String username, Long carId) {
        return null;
    }
}
