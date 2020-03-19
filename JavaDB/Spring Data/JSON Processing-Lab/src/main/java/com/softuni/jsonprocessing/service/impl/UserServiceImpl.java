package com.softuni.jsonprocessing.service.impl;

import com.softuni.jsonprocessing.dao.UserRepository;
import com.softuni.jsonprocessing.model.User;
import com.softuni.jsonprocessing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Collection<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Entity not found!"));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username).get();
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User deleteUser(long id) {
        return null;
    }

    @Override
    public long getUserCount() {
        return 0;
    }
}
