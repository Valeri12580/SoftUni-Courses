package com.softuni.automappingobjects.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddGameDto {

    @Size(min = 3, max = 100, message = "Invalid  title  of the game!")
    @Pattern(regexp = "^[A-Z][A-za-z0-9]+$",message = "Invalid title of the game!")
    private String title;


    @PositiveOrZero
    private double price;

    @PositiveOrZero
    private double size;

    @Size(min = 11, max = 11)
    private String trailer;


    @Pattern(regexp = "(http:\\/\\/|https:\\/\\/).+", message = "The thumbnail is not valid")
    private String thumbnailUrl;


    @Size(min = 20)
    private String description;

    private LocalDate date;
}
