package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private ExerciseService exerciseService;
    private UserService userService;

    @Autowired
    public HomeController(ExerciseService exerciseService, UserService userService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/";
        }

        model.addAttribute("activeExercises",this.exerciseService.getAllExerciseNames());
        model.addAttribute("topStudents",this.userService.getTopStudents());
        return "home";
    }
}
