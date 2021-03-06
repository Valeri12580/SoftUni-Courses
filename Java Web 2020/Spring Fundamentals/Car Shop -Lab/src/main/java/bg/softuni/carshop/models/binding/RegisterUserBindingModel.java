package bg.softuni.carshop.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserBindingModel {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
}
