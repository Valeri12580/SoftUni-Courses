package com.softunispring.springintro.controllers;

import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;
import com.softunispring.springintro.services.AuthorService;
import com.softunispring.springintro.services.BookService;
import com.softunispring.springintro.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seed Data
//        this.categoryService.seedCategories();
//        this.authorService.seedAuthors();
//        this.bookService.seedBooks();

        //EX 1
            this.bookService.findByReleaseDateAfter2000().forEach(e->
                            System.out.println(String.format("%s",e.getTitle()))
                    );

        //EX 2
               this.bookService.getAuthorsWithAtleastOneBookBefore1990()
                       .forEach(e-> System.out.println(e.getFirstName()+" "+e.getLastName()));

        //EX 3
        this.authorService.findAllAuthorsOrderedByCountOfBooks()
                .forEach(a -> System.out.printf("%s %s %d%n", a.getFirstName(), a.getLastName(),
                 a.getBooks().size()));

        //EX 4
        this.bookService.getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc("George","Powell")
                .forEach(e-> System.out.println(String.format("%s  %s  %d",e.getTitle(),e.getReleaseDate(),e.getCopies())));




    }
}
