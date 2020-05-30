package com.softuni.judgeversiontwo.models.binding;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
public class UserBindingModel {

    @NotNull
    @Length(min = 2,max=10,message = "Username length must be minimum 2 characters and maximum 10 characters!")
    private String username;

    @NotNull
    @Length(min = 3,max=10,message = "password length must be between 3 and 10 characters!")
    private String password;

    @NotNull
    @Length(min = 3,max=10,message = "confirm password length must be between 3 and 10 characters!")
    private String confirmPassword;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(message = "Invalid github link",regexp = "^https:\\/\\/github\\.com\\/([^\\/]+(\\/{1,1}|[^\\/]+))(?1)*$")
    private String git;


}
