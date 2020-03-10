package com.softunispring.springintro.repositories;

import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByLastName(String lastName);

    @Query("SELECT a FROM Author  as a ORDER BY  a.books.size DESC")
    List<Author> getAuthorsByCountOfBooksDesc();

    //------------------------Exercises: Spring Data Advanced Quering--------------------------------

    List<Author> getAuthorByFirstNameEndingWith(String character);

    @Query("SELECT a.firstName,a.lastName,count(b.id) FROM Author as a JOIN a.books as b WHERE concat(a.firstName,' ',a.lastName)=?1 ")
   List<Object[]> getTotalCopiesByAuthor(String author);


}
