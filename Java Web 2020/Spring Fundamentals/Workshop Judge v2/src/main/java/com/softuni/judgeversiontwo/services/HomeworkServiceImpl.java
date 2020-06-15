package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Homework;
import com.softuni.judgeversiontwo.repositories.HomeworkRepository;
import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import com.softuni.judgeversiontwo.services.interfaces.HomeworkService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private HomeworkRepository homeworkRepository;
    private UserService userService;
    private ExerciseService exerciseService;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, UserService userService, ExerciseService exerciseService) {
        this.homeworkRepository = homeworkRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @Override
    public void registerHomework(String name, String git, String username) {
        Homework homework=new Homework();
        homework.setGit(git);
        homework.setAuthor(this.userService.getUserByName(username));
        homework.setExercise(this.exerciseService.getExerciseByName(name));
        this.homeworkRepository.save(homework);

    }
}
