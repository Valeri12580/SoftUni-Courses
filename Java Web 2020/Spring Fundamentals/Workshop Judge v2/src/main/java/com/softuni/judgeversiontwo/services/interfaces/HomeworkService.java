package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.entities.Homework;
import com.softuni.judgeversiontwo.models.view.RandomHomeworkViewModel;

public interface HomeworkService {
    void registerHomework(String name,String git,String username);

    Homework getHomeworkById(long id);

    RandomHomeworkViewModel getRandomHomework();

}
