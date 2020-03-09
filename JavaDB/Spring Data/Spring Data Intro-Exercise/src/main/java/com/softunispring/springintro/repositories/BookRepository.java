package com.softunispring.springintro.repositories;

import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);


   List<Book>findAllByReleaseDateAfter(LocalDate localDate);

    @Query("SELECT b FROM Book as b Where b.author.firstName=?1 AND b.author.lastName=?2 ORDER BY b.releaseDate DESC,b.title ASC ")
    List<Book>getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc(String firstName,String lastName);

}
