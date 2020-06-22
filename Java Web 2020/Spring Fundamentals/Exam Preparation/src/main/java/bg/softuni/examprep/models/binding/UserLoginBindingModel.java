package bg.softuni.examprep.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {
    @Size(min = 2,message = "Password length must be more than two characters")
    private String username;
    @Size(min = 2,message = "Password length must be more than two characters")
    private String password;

}
