package com.fortunetelllers.services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fortunetelllers.entities.User;
import com.fortunetelllers.repository.UserRepository;

@Service
/**
 * This class named UserServices implements the UserServiceInterface in Java.
 */
public class UserServices implements UserServiceInterface {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServices.class);
    
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        logger.info("User saved successfully: {}", user);
        return user;
    }

    @Override
    public Optional<User> getUserById(String id) {
       Optional<User> user = userRepository.findById(id);
       if(user.isPresent()){
        logger.info("User found",user.get());
        return user;
       }else{
        logger.error(id+" not found");
        return Optional.empty();
       }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        User user = userRepository.findById(email).orElseThrow(()-> new ResourceNotFoundException("User not found with email: " + email));
        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        
    }

    @Override
    public List<User> getUserByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByName'");
    }
    
}
