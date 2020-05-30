package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.User;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.repositories.UserRepository;
import com.softuni.judgeversiontwo.services.interfaces.RoleService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import com.softuni.judgeversiontwo.utils.interfaces.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleService roleService;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {

        if (this.userRepository.count() == 0) {
            userServiceModel.setRoleServiceModel(this.roleService.findByName("ADMIN"));
        } else {
            userServiceModel.setRoleServiceModel(this.roleService.findByName("USER"));
        }

        User user = this.modelMapper.map(userServiceModel, User.class);

        this.userRepository.save(user);
        return userServiceModel;


    }
}
