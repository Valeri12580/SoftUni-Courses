package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.UserLoginBindingModel;
import com.softuni.judgeversiontwo.models.binding.UserRegisterBindingModel;
import com.softuni.judgeversiontwo.models.service.UserServiceModel;
import com.softuni.judgeversiontwo.models.view.UserHomeViewModel;
import com.softuni.judgeversiontwo.models.view.UserInfoViewModel;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.rmi.NoSuchObjectException;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserRegisterBindingModel());
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (!userRegisterBindingModel.getConfirmPassword().equals(userRegisterBindingModel.getPassword())) {
            bindingResult.rejectValue("confirmPassword", "confirmPassword", "Passwords are not equal!");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            return "redirect:/users/register";
        }

        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:/users/login";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute("user") UserLoginBindingModel userLoginBindingModel) {


        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") @Valid UserLoginBindingModel userLoginBindingModel
            , BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        UserHomeViewModel userHomeViewModel = null;

        //todo validation
        try {
            userHomeViewModel = this.modelMapper.map(this.userService.login(this.modelMapper.map(userLoginBindingModel, UserServiceModel.class))
                    , UserHomeViewModel.class);
        } catch (NoSuchObjectException e) {

            bindingResult.rejectValue("password", "password", "Invalid username or password");
        }

        //todo fix
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");

        } else {
            modelAndView.setViewName("redirect:/home");
            httpSession.setAttribute("user", userHomeViewModel);
        }

        return modelAndView;

    }

    @GetMapping("/profile/{id}")
    public String getProfileInfo(@PathVariable("id") long id, Model model) {
        UserInfoViewModel data = this.userService.getUserInfoById(id);
        model.addAttribute("user", data);
        return "profile";
    }


}
