package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Comment;
import com.softuni.judgeversiontwo.models.entities.Exercise;
import com.softuni.judgeversiontwo.models.entities.Homework;
import com.softuni.judgeversiontwo.models.view.RandomHomeworkViewModel;
import com.softuni.judgeversiontwo.repositories.HomeworkRepository;
import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import com.softuni.judgeversiontwo.services.interfaces.HomeworkService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import com.softuni.judgeversiontwo.utils.RandomGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private HomeworkRepository homeworkRepository;
    private UserService userService;
    private ExerciseService exerciseService;
    private ModelMapper modelMapper;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, UserService userService, ExerciseService exerciseService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerHomework(String name, String git, String username) {
        Homework homework=new Homework();
        homework.setGit(git);
        homework.setAuthor(this.userService.getUserByName(username));
        homework.setExercise(this.exerciseService.getExerciseByName(name));
        this.homeworkRepository.save(homework);

    }

    @Override
    public Homework getHomeworkById(long id) {
        return this.homeworkRepository.findById(id);
    }


    @Override
    public RandomHomeworkViewModel getRandomHomework() {
        Homework randomHomework=this.generateRandomHomework();
        RandomHomeworkViewModel view = this.modelMapper.map(randomHomework, RandomHomeworkViewModel.class);
        view.setHomeworkId(randomHomework.getId());
        return view;
    }


    public Homework generateRandomHomework() {
        long randomId=RandomGenerator.generateRandom((int) this.homeworkRepository.count());

        return this.homeworkRepository.findById(randomId);
    }
}
