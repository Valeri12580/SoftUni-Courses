package bg.softuni.exampreptwo.web.controllers;

import bg.softuni.exampreptwo.models.binding.HeroCreateBindingModel;
import bg.softuni.exampreptwo.services.interfaces.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/create")
    public String create(Model model,HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/users/login";
        }
        model.addAttribute("hero",new HeroCreateBindingModel());
        return "create-hero";
    }

    @PostMapping("/create")
    public String postCreate(@Valid @ModelAttribute("hero")HeroCreateBindingModel heroCreateBindingModel
    , HttpSession httpSession){
        heroCreateBindingModel.setUsername(httpSession.getAttribute("username").toString());
        this.heroService.addHero(heroCreateBindingModel);


        return "redirect:/home";

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model,HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/login";
        }
        model.addAttribute("hero",this.heroService.findById(id));
        return "details-hero";
    }

    @GetMapping("/delete")
    public String delete(@PathParam("id")String id,HttpSession session){
        if(session.getAttribute("username")==null){
            return "redirect:/users/login";
        }
        this.heroService.delete(id);

        return "redirect:/home";
    }
}
