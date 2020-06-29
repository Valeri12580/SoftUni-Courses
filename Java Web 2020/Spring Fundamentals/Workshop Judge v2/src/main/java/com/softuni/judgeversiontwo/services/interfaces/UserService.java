package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.entities.User;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.models.view.UserInfoViewModel;

import java.rmi.NoSuchObjectException;
import java.util.List;

public interface UserService {

    UserServiceModel register(UserServiceModel registerUserBindingModel);

    UserServiceModel login(UserServiceModel loginUserBindingModel) throws NoSuchObjectException;
    List<String>getAlUsernames();

    User getUserByName(String name);

    User getUserById(long id);

    UserInfoViewModel getUserInfoById(long id);

    void changeRoles(String username,String role);

    List<String>getTopStudents();

    long getRegisteredUsers();




}
