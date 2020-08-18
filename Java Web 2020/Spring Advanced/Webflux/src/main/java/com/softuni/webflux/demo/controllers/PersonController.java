package com.softuni.webflux.demo.controllers;

import com.softuni.webflux.configuration.ConfigProperties;
import com.softuni.webflux.demo.model.Person;
import com.softuni.webflux.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PersonController {
    private PersonService personService;
    private ConfigProperties configProperties;


    @Autowired
    public PersonController(PersonService personService, ConfigProperties configProperties) {
        this.personService = personService;
        this.configProperties = configProperties;
    }

    @GetMapping("/all")
    public Flux<Person> findALl(){
        System.out.println(configProperties.getName());
        return this.personService.getAllPersons();
    }
}
