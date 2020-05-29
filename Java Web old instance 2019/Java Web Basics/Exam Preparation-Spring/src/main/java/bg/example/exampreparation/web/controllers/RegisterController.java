package bg.example.exampreparation.web.controllers;

import bg.example.exampreparation.models.dtos.UserRegisterDto;
import bg.example.exampreparation.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


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
    public RedirectView register(@ModelAttribute UserRegisterDto userRegisterDto){

       if(!userRegisterDto.getPassword().equals(userRegisterDto.getRePassword())){
           return new RedirectView("/register");
       }

        this.userService.register(userRegisterDto);
        return new RedirectView("/login");
    }
}
