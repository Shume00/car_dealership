package com.finki.car_dealership.model.service.impl;

import com.finki.car_dealership.model.User;
import com.finki.car_dealership.model.exceptions.InvalidArgumentsException;
import com.finki.car_dealership.model.exceptions.InvalidUserCredentialsException;
import com.finki.car_dealership.model.service.AuthService;
import com.finki.car_dealership.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
