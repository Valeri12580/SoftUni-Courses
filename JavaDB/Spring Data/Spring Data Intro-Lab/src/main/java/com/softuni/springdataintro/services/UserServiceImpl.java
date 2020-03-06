package com.softuni.springdataintro.services;

import com.softuni.springdataintro.models.User;
import com.softuni.springdataintro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void registerUser(User user) {

            userRepository.save(user);
    }
}
