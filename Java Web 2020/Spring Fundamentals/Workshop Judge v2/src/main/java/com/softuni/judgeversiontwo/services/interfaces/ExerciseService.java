package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.entities.Exercise;
import com.softuni.judgeversiontwo.models.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void register(ExerciseServiceModel exerciseServiceModel);

    List<String> getAllExerciseNames();
    Exercise getExerciseByName(String name);
}
