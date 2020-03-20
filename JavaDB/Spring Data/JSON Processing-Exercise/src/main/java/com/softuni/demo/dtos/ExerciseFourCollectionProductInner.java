package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseFourCollectionProductInner {

    @Expose
    private String productName;

    @Expose
    private double productPrice;
}
