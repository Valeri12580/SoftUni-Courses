package com.softuni.judgeversiontwo.config;

import com.softuni.judgeversiontwo.utils.ValidationUtilImpl;
import com.softuni.judgeversiontwo.utils.interfaces.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }
}
