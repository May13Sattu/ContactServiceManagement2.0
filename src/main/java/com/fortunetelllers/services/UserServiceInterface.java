package com.fortunetelllers.services;

import java.util.List;
import java.util.Optional;

import com.fortunetelllers.entities.User;

public interface UserServiceInterface {
    public User saveUser(User user);
    public Optional<User> getUserById(String id);
    public Optional<User> getUserByEmail(String email);
    public Optional<User> getUserByPhoneNumber(String phoneNumber);
    public List<User> getUserByName(String name);
}
