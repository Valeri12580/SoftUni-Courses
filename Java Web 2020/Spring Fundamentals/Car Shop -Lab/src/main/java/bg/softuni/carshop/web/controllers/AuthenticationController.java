package bg.softuni.carshop.web.controllers;


import bg.softuni.carshop.models.binding.RegisterUserBindingModel;
import bg.softuni.carshop.models.service.RegisterUserServiceModel;
import bg.softuni.carshop.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

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
    public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        modelAndView.addObject("user", new RegisterUserBindingModel());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid RegisterUserBindingModel registerUserBindingModel, BindingResult bindingResult) {
        System.out.println();
        try{
            RegisterUserServiceModel registerUserServiceModel=this.modelMapper.map(registerUserBindingModel,RegisterUserServiceModel.class);

            this.userService.register(registerUserServiceModel);
        }catch (EntityExistsException e){

            return "register";
        }

        //todo redirect to login
        return "redirect:/";
    }
}
