package com.softuni.judgeversiontwo.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
@NoArgsConstructor
public class UserHomeViewModel {
    private long id;
    private String username;
    private String roleName;
}
