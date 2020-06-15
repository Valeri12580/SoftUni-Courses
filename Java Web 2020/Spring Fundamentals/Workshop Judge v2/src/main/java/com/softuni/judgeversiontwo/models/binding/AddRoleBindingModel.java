package com.softuni.judgeversiontwo.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
@NoArgsConstructor
public class AddRoleBindingModel {
    private String username;
    private String role;
}
