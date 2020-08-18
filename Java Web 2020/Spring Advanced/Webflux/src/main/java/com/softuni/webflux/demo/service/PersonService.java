package com.softuni.webflux.demo.service;

import com.softuni.webflux.demo.model.Person;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PersonService {

    private List<Person> persons=List.of(new Person("1","Valeri"),
            new Person("2","Ivan"),new Person("3","Kacho"));

    public Flux<Person> getAllPersons(){

        return Flux.fromIterable(persons);
    }
}
