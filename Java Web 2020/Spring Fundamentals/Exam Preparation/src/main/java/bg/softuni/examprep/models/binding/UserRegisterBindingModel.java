package bg.softuni.examprep.models.binding;

import bg.softuni.examprep.unitls.annotations.Unique;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    @Unique(classType = "User")
    @Size(min = 2,message = "Username length must be more than two characters!")
    private String username;

    @Email(message = "The email is not valid!")
    private String email;

    @PositiveOrZero
    private double budget;

    @Size(min = 2,message = "Password length must be more than two characters")
    private String password;

    private String confirmPassword;

}
