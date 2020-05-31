package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.UserLoginBindingModel;
import com.softuni.judgeversiontwo.models.binding.UserRegisterBindingModel;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.models.view.UserHomeViewModel;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.rmi.NoSuchObjectException;


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
        model.addAttribute("user",new UserRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserRegisterBindingModel userRegisterBindingModel , BindingResult bindingResult){

        if(!userRegisterBindingModel.getConfirmPassword().equals(userRegisterBindingModel.getPassword())){
            bindingResult.rejectValue("confirmPassword","error.confirmPassword","Passwords are not equal!");
        }

        if(bindingResult.hasErrors()){
            return "register";
        }
        System.out.println();
        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:/users/login";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new UserLoginBindingModel());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") @Valid UserLoginBindingModel userLoginBindingModel
            , BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        UserHomeViewModel userHomeViewModel=null;
        try{
            userHomeViewModel=this.modelMapper.map(this.userService.login(this.modelMapper.map(userLoginBindingModel,UserServiceModel.class))
                    ,UserHomeViewModel.class);
        } catch (NoSuchObjectException e) {
            bindingResult.reject("Incorrect username or password");
        }

        //todo fix
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("login");

        }else{
            modelAndView.setViewName("redirect:/home");
            httpSession.setAttribute("user",userHomeViewModel);
        }

        return modelAndView;

    }
}
