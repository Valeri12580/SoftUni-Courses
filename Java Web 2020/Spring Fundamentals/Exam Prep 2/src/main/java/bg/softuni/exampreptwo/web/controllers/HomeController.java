package bg.softuni.exampreptwo.web.controllers;

import bg.softuni.exampreptwo.services.interfaces.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private HeroService heroService;

    @Autowired
    public HomeController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/index";
        }

        model.addAttribute("heroes",this.heroService.getAllHeroes());
        return "home";
    }

}
