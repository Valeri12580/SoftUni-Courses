package com.softuni.judgeversiontwo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession httpSession){
        if(httpSession.getAttribute("user")==null){
            return "redirect:/";
        }
        return "home";
    }
}
