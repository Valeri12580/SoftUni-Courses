package com.softuni.judgeversiontwo.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {
    private String username;
    private String password;
    private String email;
    private String git;
    private RoleServiceModel roleServiceModel;
}
