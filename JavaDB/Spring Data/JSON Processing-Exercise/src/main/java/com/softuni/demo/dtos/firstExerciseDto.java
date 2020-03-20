package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class firstExerciseDto {
    @Expose
    private String name;

    @Expose
    private double price;

    @Expose
    private String seller;


}
