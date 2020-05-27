package bg.example.exampreparation.web.controllers;

import bg.example.exampreparation.models.dtos.UserLoginDto;
import bg.example.exampreparation.models.dtos.UserViewModel;
import bg.example.exampreparation.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    private UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLoginDto",new UserLoginDto());
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute UserLoginDto userLoginDto){

        UserViewModel user = this.userService.login(userLoginDto);
        if(user==null){
            return new RedirectView("/login");
        }
        return new RedirectView("/home");
    }


}
