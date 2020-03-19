package com.softuni.jsonprocessing.service;

import com.softuni.jsonprocessing.model.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getUsers();
    User getUserById(long id);
    User getUserByUsername(String username);
    User addUser(User user);

    User updateUser(User user);

    User deleteUser(long id);

    long getUserCount();
}
