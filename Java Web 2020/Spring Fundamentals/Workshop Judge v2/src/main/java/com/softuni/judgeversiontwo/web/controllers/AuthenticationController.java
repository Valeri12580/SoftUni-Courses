package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.UserBindingModel;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/users")
public class AuthenticationController {

    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public AuthenticationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public RedirectView register(@ModelAttribute("user")  UserBindingModel userBindingModel){

        this.userService.register(this.modelMapper.map(userBindingModel, UserServiceModel.class));

        System.out.println();


        return new RedirectView("/users/login");
    }


    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute userBindingModel){
//
//    }
}
