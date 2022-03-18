package com.finki.car_dealership.model.service;

import com.finki.car_dealership.model.User;

public interface AuthService {
    User login(String username, String password);
}
