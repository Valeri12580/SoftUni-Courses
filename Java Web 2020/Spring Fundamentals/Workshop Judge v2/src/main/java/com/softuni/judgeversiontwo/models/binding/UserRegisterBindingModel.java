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
public class UserRegisterBindingModel {


    @Length(min = 2,max=10,message = "Username length must be minimum 2 characters and maximum 10 characters!")
    private String username;


    @Length(min = 3,max=10,message = "password length must be between 3 and 10 characters!")
    private String password;


    @Length(min = 3,max=10,message = "confirm password length must be between 3 and 10 characters!")
    private String confirmPassword;


    @Email
    private String email;


//    @Pattern(message = "Invalid github link",regexp = "^https:\\/\\/github\\.com\\/(([A-Za-z0-9-._~:?#\\[\\]@!$&'()*+,;=]+)(\\/|(1?)))(1?)*$")
    private String git;


}
