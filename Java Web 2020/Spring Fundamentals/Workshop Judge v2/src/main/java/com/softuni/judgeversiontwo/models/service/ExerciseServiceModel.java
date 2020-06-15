package com.softuni.judgeversiontwo.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseServiceModel {
    private int id;
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueTime;
}
