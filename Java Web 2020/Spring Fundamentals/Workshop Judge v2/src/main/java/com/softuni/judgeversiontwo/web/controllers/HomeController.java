package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.services.interfaces.CommentService;
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
    private CommentService commentService;

    @Autowired
    public HomeController(ExerciseService exerciseService, UserService userService, CommentService commentService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/home")
    public String home(Model model,HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/";
        }

        model.addAttribute("activeExercises",this.exerciseService.getAllExerciseNames());
        model.addAttribute("topStudents",this.userService.getTopStudents());
        model.addAttribute("registeredCount",this.userService.getRegisteredUsers());
        model.addAttribute("averageScore",this.commentService.getAverage());
        return "home";
    }
}
