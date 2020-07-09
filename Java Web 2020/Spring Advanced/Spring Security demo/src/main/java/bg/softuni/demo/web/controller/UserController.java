package bg.softuni.demo.web.controller;

import bg.softuni.demo.entities.User;
import bg.softuni.demo.repositories.RoleRepository;
import bg.softuni.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping( value= "/users")
public class UserController {
    private UserServiceImpl userService;

    private RoleRepository roleRepository;

    @Autowired
    public UserController(UserServiceImpl userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mv){
        mv.setViewName("register");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute User user, ModelAndView mv){

        if(this.userService.isEmpty()){
            user.setRoles(Set.of(this.roleRepository.findRoleByRole("ADMIN")));
        }else{
            user.setRoles(Set.of(this.roleRepository.findRoleByRole("USER")));
        }


        this.userService.register(user);
        mv.setViewName("redirect:/home");
        return mv;
    }
}
