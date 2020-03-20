package com.softuni.demo.services.impl;

import com.google.gson.Gson;
import com.softuni.demo.dtos.*;
import com.softuni.demo.entities.User;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.UserService;
import com.softuni.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMap;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMap) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMap = modelMap;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        User[]users=this.gson.fromJson(new FileReader("src/main/resources/files/users.json"),User[].class);
        for (User user : users) {
            if(validationUtil.isValid(user)){
                this.userRepository.save(user);
            }else{
                validationUtil.getViolations(user)
                        .forEach(e-> System.out.println(e.getMessage()));
            }
        }

    }

    @Override
    public User getRandomBuyer() {
        Random random =new Random();

        long number=random.nextInt((int)this.userRepository.count()+15)+1;


        return this.userRepository.findById(number).orElse(null);
    }

    @Override
    public User getRandomSeller() {
        Random random =new Random();

        long number=random.nextInt((int)this.userRepository.count())+1;


        return this.userRepository.findById(number).get();

    }

    @Override
    public String secondExercise() {
        List<secondExerciseDto>result=this.userRepository.secondExercise()
                .stream().map(u->{

                    return this.modelMap.map(u,secondExerciseDto.class);
                }).collect(Collectors.toList());

        return this.gson.toJson(result);
    }

    @Override
    public String exerciseFour() {
        List<ExerciseFourDtoInner> res = this.userRepository.exerciseFour()
                .stream()
                .map(u -> {

                        ExerciseFourDtoInner result=this.modelMap.map(u,ExerciseFourDtoInner.class);



                    System.out.println();
                    return result;
                }).collect(Collectors.toList());


        System.out.println();
        return null;
    }
}
