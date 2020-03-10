package com.softunispring.springintro.services;

import com.softunispring.springintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;


    long getAllAuthorsCount();
    Author findAuthorById(Long id);

    List<Author> findAllAuthorsOrderedByCountOfBooks();

    //------------------------Exercises: Spring Data Advanced Quering--------------------------------

    void exerciseSix(String character);

    void exerciseTen(String author);





}
