package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ThirdExerciseDto {
    @Expose
    private String categoryName;

    @Expose
    private int productsCount;


    @Expose
    private double averagePrice;

    @Expose
    private double totalRevenue;
}
