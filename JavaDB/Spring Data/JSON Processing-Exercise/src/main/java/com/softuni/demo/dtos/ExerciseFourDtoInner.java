package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseFourDtoInner {
    @Expose
    private String userFirstName;

    @Expose
    private String userLastName;

    @Expose
    private int userAge;

    @Expose
    private List<ExerciseFourCollectionProducts> sold;
    //
}
