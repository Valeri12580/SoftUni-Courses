package com.softuni.demo.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseFourDtoOuter {
    @Expose
    private  int   usersCount;

    @Expose
    List<ExerciseFourDtoInner> users;

}
