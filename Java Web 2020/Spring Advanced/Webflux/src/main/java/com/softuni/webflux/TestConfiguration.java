package com.softuni.webflux;

import com.softuni.webflux.configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestConfiguration implements CommandLineRunner {
    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(configProperties.toString());
    }
}
