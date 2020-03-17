package com.softuni.automappingobjects.services.implementation;

import com.softuni.automappingobjects.entities.Login;
import com.softuni.automappingobjects.entities.Role;
import com.softuni.automappingobjects.entities.User;
import com.softuni.automappingobjects.entities.dtos.LoginUserDto;
import com.softuni.automappingobjects.entities.dtos.RegisterUserDto;
import com.softuni.automappingobjects.repositories.UserRepository;
import com.softuni.automappingobjects.services.interfaces.UserService;
import net.minidev.json.JSONUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public User user;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.user=null;
    }

    @Override
    public void registerUser(RegisterUserDto dtoRegisterUser) {

        User user = modelMapper.map(dtoRegisterUser, User.class);

        if(this.userRepository.count()==0){
            user.setRole(Role.Administrator);
        }else{
            user.setRole(Role.User);
        }

        this.userRepository.save(user);
        System.out.println(String.format("%s was registered",user.getFullName()));
    }

    @Override
    public void loginUser(LoginUserDto loginUserDto) {
        User currentUser=this.userRepository.findByEmailAndPassword(loginUserDto.getEmail(),loginUserDto.getPassword());
        if(currentUser==null){
            System.out.println("Wrong credentials");
        }else{
            if(currentUser==this.user){
                System.out.println("The user is already logged!");
            }else{
                this.user=currentUser;
                System.out.println(String.format("Successfully logged in %s",currentUser.getFullName()));

            }
        }
    }

    @Override
    public void logout() {

        if(user!=null){
            this.user=null;
            System.out.println("Logged out!");
        }else{
            System.out.println("Cannot log out. No user was logged in.");
        }

    }
}
