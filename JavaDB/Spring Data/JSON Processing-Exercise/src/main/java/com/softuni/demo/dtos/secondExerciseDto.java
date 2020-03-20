package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.demo.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class secondExerciseDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductDtoSecondExercise>sold;
}
