package bg.softuni.examprep.web.controllers;

import bg.softuni.examprep.models.binding.UserLoginBindingModel;
import bg.softuni.examprep.models.binding.UserRegisterBindingModel;
import bg.softuni.examprep.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //post redirect get
    @GetMapping("/register")
    public String register(Model model, HttpSession session) {

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("user") UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult result, RedirectAttributes redirectAttributes) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "confirmPassword", "The passwords are not equal!");
        }

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", userRegisterBindingModel);
            return "redirect:/users/register";
        }
        this.userService.register(userRegisterBindingModel);

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserLoginBindingModel());
        }

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute("user") UserLoginBindingModel userLoginBindingModel,
                            BindingResult result,RedirectAttributes redirectAttributes,HttpSession session) {

        if(!this.userService.isUserInDatabase(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword())){
           result.rejectValue("username","username","Wrong username or password");
        }

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("user",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user",result);
            return "redirect:/users/login";
        }



        session.setAttribute("user",userLoginBindingModel.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }


}
