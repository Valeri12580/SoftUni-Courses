package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contacts;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    private List<Contacts>contacts;

    public ContactController(){
        this.contacts=new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts",contacts);
        return  modelAndView;

    }
    @PostMapping("/")
    public String add(Contacts contacts){
        this.contacts.add(contacts);
        return "redirect:/";
    }



}

