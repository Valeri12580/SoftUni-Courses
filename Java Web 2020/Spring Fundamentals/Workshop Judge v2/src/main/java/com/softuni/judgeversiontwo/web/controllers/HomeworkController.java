package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.HomeworkBindingModel;
import com.softuni.judgeversiontwo.models.view.UserHomeViewModel;
import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import com.softuni.judgeversiontwo.services.interfaces.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private ExerciseService exerciseService;
    private HomeworkService homeworkService;

    @Autowired
    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }


    @GetMapping("/add")
    public String registerHomework(Model model){
        model.addAttribute("homework",new HomeworkBindingModel());
        model.addAttribute("exercises",this.exerciseService.getAllExerciseNames());
        return "homework-add";
    }

    @PostMapping("/add")
    public String homeworkSubmit(@ModelAttribute @Valid HomeworkBindingModel homeworkBindingModel, BindingResult bindingResult, HttpSession session){
        //bind username
        UserHomeViewModel user= (UserHomeViewModel) session.getAttribute("user");
        this.homeworkService.registerHomework(homeworkBindingModel.getName(),homeworkBindingModel.getGit(),user.getUsername());
        System.out.println();
        return "redirect:/home";
    }
}
