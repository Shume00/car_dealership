package com.finki.car_dealership.repository;

import com.finki.car_dealership.model.User;
import com.finki.car_dealership.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {
    Optional<Wishlist> findByUser(User user);
}
