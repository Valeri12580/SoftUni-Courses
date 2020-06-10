package bg.softuni.carshop.models.service;

import bg.softuni.carshop.models.entity.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserServiceModel {
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private UserRole userRole;
}
