package bg.example.exampreparation.web.controllers;

import bg.example.exampreparation.models.dtos.UserRegisterDto;
import bg.example.exampreparation.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
    private UserServiceImpl userService;

    @Autowired
    public RegisterController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
       model.addAttribute("userRegisterDto",new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterDto userRegisterDto){
        System.out.println();
        return "index";
    }
}
