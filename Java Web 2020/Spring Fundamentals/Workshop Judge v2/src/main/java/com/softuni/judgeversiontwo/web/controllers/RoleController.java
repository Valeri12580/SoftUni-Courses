package com.softuni.judgeversiontwo.web.controllers;

import com.softuni.judgeversiontwo.models.binding.AddRoleBindingModel;
import com.softuni.judgeversiontwo.models.view.UserHomeViewModel;
import com.softuni.judgeversiontwo.services.interfaces.RoleService;
import com.softuni.judgeversiontwo.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public RoleController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/add")
    public String getRoleForm(Model model, HttpSession session){
        UserHomeViewModel user=(UserHomeViewModel)session.getAttribute("user");
        if(!user.getRoleName().equals("ADMIN")){
            return "redirect:/home";
        }

        model.addAttribute("model",new AddRoleBindingModel());
        model.addAttribute("users",this.userService.getAlUsernames());
        return "role-add";
    }


    @PostMapping("/add")
    public String submitRoleForm(@ModelAttribute @Valid AddRoleBindingModel addRoleBindingModel
    , BindingResult result){

        if(result.hasErrors()){
            return "role-add";
        }
        this.userService.changeRoles(addRoleBindingModel.getUsername(),addRoleBindingModel.getRole());
        System.out.println();
        return "redirect:/home";
    }
}
