package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ExerciseFourCollectionProducts {
    @Expose
    private int count;
    @Expose
    private List<ExerciseFourCollectionProductInner>product;

}
