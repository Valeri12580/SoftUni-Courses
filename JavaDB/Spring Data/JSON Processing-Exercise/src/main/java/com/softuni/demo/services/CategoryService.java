package com.softuni.demo.services;

import com.softuni.demo.entities.Category;

import java.io.FileNotFoundException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws FileNotFoundException;

    Set<Category> generateRandomCategories();

    String thirdExercise();

}
