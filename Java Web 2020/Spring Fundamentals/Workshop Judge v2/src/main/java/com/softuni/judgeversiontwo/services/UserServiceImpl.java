package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Role;
import com.softuni.judgeversiontwo.models.entities.User;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.repositories.UserRepository;
import com.softuni.judgeversiontwo.services.interfaces.RoleService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import com.softuni.judgeversiontwo.utils.interfaces.ValidationUtil;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.stream.Collectors;

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
            userServiceModel.setRole(this.roleService.findByName("ADMIN"));
        } else {
            userServiceModel.setRole(this.roleService.findByName("USER"));
        }

        User user = this.modelMapper.map(userServiceModel, User.class);

        this.userRepository.save(user);
        return userServiceModel;


    }

    @Override
    public UserServiceModel login(UserServiceModel loginUserModel) throws NoSuchObjectException {
        User user = this.userRepository.findByUsernameAndPassword(loginUserModel.getUsername(), loginUserModel.getPassword());

        if (user == null) {
            throw new NoSuchObjectException("Incorrect username or password");
        }
        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<String> getAlUsernames() {

        return this.userRepository.findAll().stream().map(e -> e.getUsername()).collect(Collectors.toList());
    }

    @Override
    public User getUserByName(String name) {
        return this.userRepository.findByUsername(name);
    }

    @Override
    public void changeRoles(String username, String role) {
        User user = this.userRepository.findByUsername(username);
        Role fetchedRole = this.roleService.findByName(role);
        user.setRole(fetchedRole);
        this.userRepository.save(user);

    }
}
