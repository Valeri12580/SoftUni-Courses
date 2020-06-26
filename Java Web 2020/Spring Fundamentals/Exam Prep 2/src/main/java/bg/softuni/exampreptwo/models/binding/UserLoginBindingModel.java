package bg.softuni.exampreptwo.models.binding;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginBindingModel {

    @NotNull
    @Size(min = 2,message = "The username must be more than 2 characters!")
    private String username;

    @NotNull
    @Size(min = 2,message = "The password must be more than 2 characters!")
    private String password;
}
