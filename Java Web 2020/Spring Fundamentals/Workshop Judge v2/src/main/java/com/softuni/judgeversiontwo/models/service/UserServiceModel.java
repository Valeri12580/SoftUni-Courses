package com.softuni.judgeversiontwo.models.service;

import com.softuni.judgeversiontwo.models.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {
    private long id;
    private String username;
    private String password;
    private String email;
    private String git;
    private Role role;
}
