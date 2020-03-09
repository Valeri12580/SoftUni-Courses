package com.softunispring.springintro.services;

import com.softunispring.springintro.entities.Category;

import java.io.IOException;

public interface CategoryService {

    void seedCategories() throws IOException;
    Category getCategoryById(Long id);

}
