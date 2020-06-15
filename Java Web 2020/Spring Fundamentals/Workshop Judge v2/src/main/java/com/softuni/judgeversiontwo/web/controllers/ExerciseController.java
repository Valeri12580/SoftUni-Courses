package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.ExerciseBindingModel;
import com.softuni.judgeversiontwo.models.service.ExerciseServiceModel;
import com.softuni.judgeversiontwo.models.view.UserHomeViewModel;
import com.softuni.judgeversiontwo.services.interfaces.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {
    private ModelMapper modelMapper;
    private ExerciseService exerciseService;

    public ExerciseController(ModelMapper modelMapper, ExerciseService exerciseService) {
        this.modelMapper = modelMapper;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public String  addExercise(Model model, HttpSession session){
        UserHomeViewModel user = (UserHomeViewModel) session.getAttribute("user");

        if(user==null ){
            return "redirect:/";
        }else if ( user.getRoleName().equals("USER")){
            return "redirect:/home";
        }
        model.addAttribute("exercise",new ExerciseBindingModel());
        return "exercise-add";
    }

    @PostMapping("/add")
    public String registerExercise(@Valid @ModelAttribute ExerciseBindingModel exerciseBindingModel,
            BindingResult result){
        //todo validation errors
        if(result.hasErrors()){
            return "exercise-add";
        }
        this.exerciseService.register(this.modelMapper.map(exerciseBindingModel, ExerciseServiceModel.class));

        return "redirect:/home";
    }


}
