package bg.softuni.exampreptwo.models.binding;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {
    @NotNull
    @Size(min = 2,message = "The username must be more than 2 characters!")
    private String username;

    @NotNull
    @Email(message = "The email is not valid!")
    private String email;

    @NotNull
    @Size(min = 2,message = "The password must be more than 2 characters!")
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    @Size(min = 2,message = "The country must be more than 2 characters!")
    private String country;
}
