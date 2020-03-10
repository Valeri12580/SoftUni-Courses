package com.softunispring.springintro.services;

import com.softunispring.springintro.entities.AgeRestriction;
import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<Book>findByReleaseDateAfter2000();

    Set<Author> getAuthorsWithAtleastOneBookBefore1990();

    List<Book>getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc(String firstName,String  lastName);

    //------------------------Exercises: Spring Data Advanced Quering--------------------------------

        void firstExercise(String ageRestriction);

        void secondExercise();

        void thirdExercise();

        void exerciseFour(int year);

        void exerciseFive(String date);

        void exerciseSeven(String input);

        void exerciseEight(String input);

        void exerciseNine(int count);

        void exerciseEleven(String title);


}
