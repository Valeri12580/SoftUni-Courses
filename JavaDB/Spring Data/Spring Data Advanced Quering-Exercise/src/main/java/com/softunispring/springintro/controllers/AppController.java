package com.softunispring.springintro.controllers;

import com.softunispring.springintro.services.AuthorService;
import com.softunispring.springintro.services.BookService;
import com.softunispring.springintro.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;


    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader reader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;

        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {
        //seed Data
//        this.categoryService.seedCategories();
//        this.authorService.seedAuthors();
//        this.bookService.seedBooks();

        //first exercise

//        System.out.println("Input:");
////        this.bookService.firstExercise(reader.readLine());


        //secondExercise
//        this.bookService.secondExercise();

        //thirdExercise
//        this.bookService.thirdExercise();


        //exercise four
//        System.out.println("Input:");
//        this.bookService.exerciseFour(Integer.parseInt(reader.readLine()));

        //exercise five

//        System.out.println("Input");
//        this.bookService.exerciseFive(reader.readLine());

        //exercise six
//        System.out.println("Input");
//        this.authorService.exerciseSix(reader.readLine());


        //exerciseSeven
//        System.out.println("input");
//        this.bookService.exerciseSeven(reader.readLine());

        //exerciseEight
        //резултатите 100% не са като на примера и това не е грешка!
//        System.out.println("input");
//        this.bookService.exerciseEight(reader.readLine());

        //exerciseNine
//        System.out.println("Input:");
//        this.bookService.exerciseNine(Integer.parseInt(reader.readLine()));

        //exerciseTen
        ////резултатите 100% не са като на примера и това не е грешка!
        //пиши имената на авторите ръчно
//        System.out.println("Input:");
//        this.authorService.exerciseTen(reader.readLine());

        //еxerciseEleven
        System.out.println("Input:");
        this.bookService.exerciseEleven(reader.readLine());

    }
}
