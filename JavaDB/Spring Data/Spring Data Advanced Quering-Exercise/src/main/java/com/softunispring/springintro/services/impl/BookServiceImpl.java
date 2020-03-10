package com.softunispring.springintro.services.impl;

import com.softunispring.springintro.entities.*;
import com.softunispring.springintro.repositories.BookRepository;
import com.softunispring.springintro.services.AuthorService;
import com.softunispring.springintro.services.BookService;
import com.softunispring.springintro.services.CategoryService;
import com.softunispring.springintro.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.softunispring.springintro.constants.GlobalConstants.BOOKS_FILE_PATH;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final FileUtil fileUtil;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {

        String[] fileContent = this.fileUtil.readFileContent(BOOKS_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {

            String[] params = r.split("\\s+");
            Author author = this.getRandomAuthor();
            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = this.getTitle(params);
            Set<Category> categories = this.getRandomCategories();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);
              if (!this.bookRepository.existsByTitle(book.getTitle())) {
                 this.bookRepository.saveAndFlush(book);
             }
        });
    }

    @Override
    public List<Book> findByReleaseDateAfter2000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000", formatter);

        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }


    private Set<Category> getRandomCategories() {
        Set<Category> result = new HashSet<>();

        Random random = new Random();
        int bound = random.nextInt(3) + 1;

        for (int i = 1; i <= bound; i++) {
            result.add(this.categoryService.getCategoryById((long) i));
        }
        return result;
    }

    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();

        for (int i = 5; i < params.length; i++) {
            sb.append(params[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private Author getRandomAuthor() {

        Random random = new Random();

        long randomId = random.nextInt((int) authorService.getAllAuthorsCount()) + 1;

        return this.authorService.findAuthorById(randomId);
    }

    @Override
    public Set<Author> getAuthorsWithAtleastOneBookBefore1990() {
        Set<Author>authors=new HashSet<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("01/01/1990", formatter);
        this.bookRepository.findAllByReleaseDateAfter(releaseDate)
                .forEach(e->authors.add(e.getAuthor()));
        return authors;
    }

    @Override
    public List<Book> getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc(String firstName,String lastName) {
        return this.bookRepository.getAllBooksByAuthorOrderByReleaseDateThenByTitleAsc(firstName,lastName);
    }

    //------------------------Exercises: Spring Data Advanced Quering--------------------------------


    @Override
    public void firstExercise(String ageRestriction) {
        AgeRestriction ageRestrictionEnum=AgeRestriction.valueOf(ageRestriction.toUpperCase());
        this.bookRepository.findAllByAgeRestriction(ageRestrictionEnum)
        .forEach(e-> System.out.println(e.getTitle()));
    }

    @Override
    public void secondExercise() {
        this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf("GOLD"),5000)
        .forEach(e-> System.out.println(e.getTitle()));
    }

    @Override
    public void thirdExercise() {
        this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(new BigDecimal("5"),new BigDecimal("40"))
                .forEach(e-> System.out.println(e.getTitle()+" - $"+e.getPrice()));
    }

    @Override
    public void exerciseFour(int year) {
            LocalDate before =LocalDate.of(year,1,1);
            LocalDate after=LocalDate.of(year,12,31);

            this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before,after)
                    .forEach(e-> System.out.println(e.getTitle()));
    }

    @Override
    public void exerciseFive(String date) {
        String[] split = date.split("-");
        LocalDate parsedDate=LocalDate.of(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]));
       this.bookRepository.findAllByReleaseDateBefore(parsedDate)
       .forEach(e-> System.out.println(String.format("%s %s %.2f",e.getTitle(),e.getEditionType(),e.getPrice())));
    }

    @Override
    public void exerciseSeven(String input) {

        this.bookRepository.findAllByTitleIgnoreCaseContaining(input)
                .forEach(e-> System.out.println(e.getTitle()));
    }

    @Override
    public void exerciseEight(String input) {
            this.bookRepository.findAllByAuthorLastNameStartingWith(input)
                    .forEach(e-> System.out.println(String.format("%s ( %s %s)",e.getTitle(),e.getAuthor().getFirstName(),e.getAuthor().getLastName())));
    }

    @Override
    public void exerciseNine(int count) {
        System.out.println(this.bookRepository.findAllByTitleGreaterThan(count));
    }

    @Override
    public void exerciseEleven(String title) {
        List<Object[]> bookOnlyByRequiredFields = this.bookRepository.getBookOnlyByRequiredFields(title);
        System.out.println(String.format("%s %s %s %s",bookOnlyByRequiredFields.get(0)[0],bookOnlyByRequiredFields.get(0)[1],bookOnlyByRequiredFields.get(0)[2],bookOnlyByRequiredFields.get(0)[3]));
    }
}
