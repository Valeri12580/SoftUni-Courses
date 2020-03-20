package com.softuni.demo.services;

import com.softuni.demo.entities.User;

import java.io.FileNotFoundException;

public interface UserService {

    void seedUsers() throws FileNotFoundException;

    User getRandomBuyer();

    User getRandomSeller();

    String secondExercise();

    String exerciseFour();
}
