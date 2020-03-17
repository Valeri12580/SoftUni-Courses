package com.softuni.automappingobjects.services.interfaces;

import com.softuni.automappingobjects.entities.dtos.LoginUserDto;
import com.softuni.automappingobjects.entities.dtos.RegisterUserDto;

public interface UserService {

    void registerUser(RegisterUserDto dtoRegisterUser);

    void loginUser(LoginUserDto loginUserDto);

    void logout();
}
