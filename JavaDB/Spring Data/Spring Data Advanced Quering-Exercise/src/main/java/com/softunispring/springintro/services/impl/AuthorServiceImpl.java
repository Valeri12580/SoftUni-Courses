package com.softunispring.springintro.services.impl;

import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;
import com.softunispring.springintro.repositories.AuthorRepository;
import com.softunispring.springintro.services.AuthorService;
import com.softunispring.springintro.services.BookService;
import com.softunispring.springintro.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import static com.softunispring.springintro.constants.GlobalConstants.AUTHORS_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        String[] fileContent = this.fileUtil.readFileContent(AUTHORS_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+");
            Author author = new Author(params[0], params[1]);
            if (!this.authorRepository.existsByLastName(author.getLastName())) {
                this.authorRepository.saveAndFlush(author);
            }
        });

    }



    @Override
    public long getAllAuthorsCount() {
        return this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(Long id) {
        return this.authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsOrderedByCountOfBooks() {
        return this.authorRepository.getAuthorsByCountOfBooksDesc();
    }
    //------------------------Exercises: Spring Data Advanced Quering--------------------------------


    @Override
    public void exerciseSix(String character) {
        this.authorRepository.getAuthorByFirstNameEndingWith(character)
        .forEach(e-> System.out.println(e.getFirstName()+" " +e.getLastName()));
    }

    @Override
    public void exerciseTen(String author) {
           List<Object[]> result= this.authorRepository.getTotalCopiesByAuthor(author);
        System.out.println(String.format("%s %s - %s",result.get(0)[0],result.get(0)[1],result.get(0)[2]));

    }
}
