package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDtoSecondExercise {
    @Expose
    private String productName;

    @Expose
    private double productPrice;
    @Expose
    private String buyerFirstName;

    @Expose
    private String buyerLastName;
}
