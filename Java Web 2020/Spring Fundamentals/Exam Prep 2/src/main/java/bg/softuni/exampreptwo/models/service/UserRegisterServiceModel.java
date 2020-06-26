package bg.softuni.exampreptwo.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterServiceModel {

    private String username;


    private String email;


    private String password;


    private String confirmPassword;

    private String country;

}
