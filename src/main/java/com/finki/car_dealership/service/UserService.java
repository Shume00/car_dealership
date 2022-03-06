package com.finki.car_dealership.service;

import com.finki.car_dealership.model.Role;
import com.finki.car_dealership.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User register(String username, String password, String name, String surname, Role role);
    UserDetails loadUserByUsername (String username);
}
