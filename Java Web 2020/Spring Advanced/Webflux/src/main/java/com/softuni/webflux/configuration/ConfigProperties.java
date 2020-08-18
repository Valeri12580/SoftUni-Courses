package com.softuni.webflux.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("test")
public class ConfigProperties {

    private String name;

    private int age;

    private String[]hobbies;

    private String[]courses;

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public ConfigProperties() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "ConfigProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
