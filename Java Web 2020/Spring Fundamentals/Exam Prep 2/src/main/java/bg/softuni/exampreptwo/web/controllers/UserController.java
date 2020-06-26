package bg.softuni.exampreptwo.web.controllers;

import bg.softuni.exampreptwo.models.binding.UserLoginBindingModel;
import bg.softuni.exampreptwo.models.binding.UserRegisterBindingModel;
import bg.softuni.exampreptwo.models.service.UserRegisterServiceModel;
import bg.softuni.exampreptwo.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserRegisterBindingModel());


        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("user")UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult){

        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            bindingResult.rejectValue("confirmPassword","confirmPassword","Passwords doesnt match!");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }

        this.userService.register(this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class));
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new UserLoginBindingModel());

        return "login";
    }

    @PostMapping("login")
    public String postLogin(@Valid @ModelAttribute("user")UserLoginBindingModel user
            , BindingResult bindingResult, HttpSession session){

        if(!this.userService.isCredentialsValid(user.getUsername(),user.getPassword())){
            bindingResult.rejectValue("username","username","Invalid username or password!");
        }

        if(bindingResult.hasErrors()){
            return "login";
        }

        session.setAttribute("username",user.getUsername());
        return "redirect:/home";

    }
}
