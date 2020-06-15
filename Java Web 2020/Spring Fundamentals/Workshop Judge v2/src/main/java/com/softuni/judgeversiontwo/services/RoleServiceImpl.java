package com.softuni.judgeversiontwo.services;

import com.softuni.judgeversiontwo.models.entities.Role;
import com.softuni.judgeversiontwo.models.service.RoleServiceModel;
import com.softuni.judgeversiontwo.repositories.RoleRepository;
import com.softuni.judgeversiontwo.services.interfaces.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        if(this.roleRepository.count()==0){
            this.roleRepository.save(new Role("ADMIN"));
            this.roleRepository.save(new Role("USER"));
        }
    }

    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByName(name);
    }


}
