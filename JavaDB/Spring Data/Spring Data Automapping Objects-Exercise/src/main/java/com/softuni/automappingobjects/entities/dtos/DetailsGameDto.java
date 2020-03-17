package com.softuni.automappingobjects.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailsGameDto {
    private String title;
    private String description;
    private double price;
    private LocalDate releaseDate;

}
