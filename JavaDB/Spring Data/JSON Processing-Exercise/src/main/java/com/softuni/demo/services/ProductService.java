package com.softuni.demo.services;

import java.io.FileNotFoundException;

public interface ProductService {
    void seedProducts() throws FileNotFoundException;

    String firstExercise(double low, double high);
}
