package com.softuni.judgeversiontwo.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {
    @Length(min=2,message = "Username must be more than 2 characters")
    private String username;

    @Length(min = 3,message = "Password must be more than 3 characters")
    private String password;


}
