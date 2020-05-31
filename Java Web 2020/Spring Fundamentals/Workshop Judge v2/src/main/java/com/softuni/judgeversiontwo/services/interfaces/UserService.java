package com.softuni.judgeversiontwo.services.interfaces;

import com.softuni.judgeversiontwo.models.service.UserServiceModel;

import java.rmi.NoSuchObjectException;

public interface UserService {

    UserServiceModel register(UserServiceModel registerUserBindingModel);

    UserServiceModel login(UserServiceModel loginUserBindingModel) throws NoSuchObjectException;


}
