package com.finki.car_dealership.model.service.impl;

import com.finki.car_dealership.model.Car;
import com.finki.car_dealership.model.User;
import com.finki.car_dealership.model.Wishlist;
import com.finki.car_dealership.model.exceptions.CarAlreadyInWishlistException;
import com.finki.car_dealership.model.exceptions.CarNotFoundException;
import com.finki.car_dealership.model.exceptions.UserNotFoundException;
import com.finki.car_dealership.model.exceptions.WishlistNotFoundException;
import com.finki.car_dealership.repository.CarRepository;
import com.finki.car_dealership.repository.UserRepository;
import com.finki.car_dealership.repository.WishlistRepository;
import com.finki.car_dealership.model.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public Wishlist getWishlist(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.wishlistRepository
                .findByUser(user)
                .orElseGet(() -> {
                    Wishlist wishlist = new Wishlist(user);
                    return this.wishlistRepository.save(wishlist);
                });
    }


    @Override
    public List<Car> listAllCarsInWishlist(Long wishlistId) {
        if(this.wishlistRepository.findById(wishlistId).isEmpty())
            throw new WishlistNotFoundException(wishlistId);
        return this.wishlistRepository.findById(wishlistId).get().getCars();
    }

    @Override
    public Wishlist addCarToWishlist(String username, Long carId) {
        Wishlist wishlist = this.getWishlist(username);
        Car car = this.carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(carId));
        if(wishlist.getCars()
                .stream().anyMatch(i -> i.getId().equals(carId)))
            throw new CarAlreadyInWishlistException(carId, username);
        wishlist.getCars().add(car);
        return this.wishlistRepository.save(wishlist);
    }


}