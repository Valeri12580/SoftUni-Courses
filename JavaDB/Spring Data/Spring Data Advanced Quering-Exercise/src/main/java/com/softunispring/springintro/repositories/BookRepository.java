package com.softunispring.springintro.repositories;

import com.softunispring.springintro.entities.AgeRestriction;
import com.softunispring.springintro.entities.Author;
import com.softunispring.springintro.entities.Book;
import com.softunispring.springintro.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);

   List<Book>findAllByReleaseDateAfter(LocalDate localDate);

    @Query("SELECT b FROM Book as b Where b.author.firstName=?1 AND b.author.lastName=?2 ORDER BY b.releaseDate DESC,b.title ASC ")
    List<Book>getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc(String firstName,String lastName);

    //------------------------Exercises: Spring Data Advanced Quering--------------------------------

    List<Book>findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book>findAllByEditionTypeAndCopiesLessThan(EditionType editionType,int copies);

    List<Book>findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);


    List<Book>findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before,LocalDate after);

    List<Book>findAllByReleaseDateBefore(LocalDate date);

    List<Book>findAllByTitleIgnoreCaseContaining(String input);


    @Query("SELECT b FROM Book  as b JOIN  b.author as a WHERE a.lastName like CONCAT(:input,'%') ")
    List<Book>findAllByAuthorLastNameStartingWith(@Param("input") String param);

    @Query("SELECT COUNT(b.id) FROM Book  as b WHERE length (b.title)>?1 ")
    int findAllByTitleGreaterThan(int number);


    @Query("SELECT b.title,b.editionType,b.ageRestriction,b.price from Book b WHERE b.title=:title")
   List<Object[]> getBookOnlyByRequiredFields(@Param("title")String title);
}
