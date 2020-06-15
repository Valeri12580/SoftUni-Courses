package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.entities.User;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;

import java.rmi.NoSuchObjectException;
import java.util.List;

public interface UserService {

    UserServiceModel register(UserServiceModel registerUserBindingModel);

    UserServiceModel login(UserServiceModel loginUserBindingModel) throws NoSuchObjectException;
    List<String>getAlUsernames();

    User getUserByName(String name);

    void changeRoles(String username,String role);


}
