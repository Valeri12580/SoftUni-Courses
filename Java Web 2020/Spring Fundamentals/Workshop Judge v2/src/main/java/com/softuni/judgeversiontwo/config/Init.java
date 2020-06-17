package com.softuni.judgeversiontwo.config;

import com.softuni.judgeversiontwo.models.entities.Role;
import com.softuni.judgeversiontwo.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Init {

    private RoleRepository roleRepository;

    @Autowired
    public Init(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init(){
        if(roleRepository.count()==0){
            this.roleRepository.saveAll(List.of(new Role("ADMIN"),new Role("USER")));
        }
    }
}
