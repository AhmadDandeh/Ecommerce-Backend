package com.ahmad.ecommerce.service;

import com.ahmad.ecommerce.entity.User;
import com.ahmad.ecommerce.repository.UserRepository;

import java.util.Optional;

public class UserService {

    UserRepository userRepository = UserRepository.getInstance();

    public void register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            System.out.println("Error: User with email " + user.getEmail() + " already exists.");
            return;
        }
        userRepository.save(user);
        System.out.println("User registered successfully!");
    }

    public Optional<User> login(String email, String password){
        return userRepository.findByEmail(email).filter(u -> u.getPassword().equals(password));
    }

    public void updateProfile(User user){
        userRepository.findByEmail(user.getEmail()).ifPresent(oldUser -> {
            userRepository.findAll().remove(oldUser);
            userRepository.save(user);
        });
    }
}
