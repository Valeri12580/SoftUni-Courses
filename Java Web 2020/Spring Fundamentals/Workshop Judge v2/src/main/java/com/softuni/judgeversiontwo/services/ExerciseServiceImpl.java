package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Exercise;
import com.softuni.judgeversiontwo.models.service.ExerciseServiceModel;
import com.softuni.judgeversiontwo.repositories.ExerciseRepository;
import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl  implements ExerciseService {
    private ModelMapper modelMapper;
    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ModelMapper modelMapper, ExerciseRepository exerciseRepository) {
        this.modelMapper = modelMapper;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void register(ExerciseServiceModel exerciseServiceModel) {
        Exercise exercise=this.modelMapper.map(exerciseServiceModel,Exercise.class);
        this.exerciseRepository.save(exercise);

    }

    @Override
    public List<String> getAllExerciseNames() {
        return this.exerciseRepository.findAll().stream().map(Exercise::getName).collect(Collectors.toList());
    }

    @Override
    public Exercise getExerciseByName(String name) {
        return this.exerciseRepository.findByName(name);
    }
}
