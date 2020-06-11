package bg.softuni.carshop.services.interfaces;

import bg.softuni.carshop.models.entity.User;
import bg.softuni.carshop.models.service.RegisterUserServiceModel;
import bg.softuni.carshop.models.view.UserCreateOfferViewModel;

import java.util.List;

public interface UserService {

    void register(RegisterUserServiceModel registerUserServiceModel);

    List<UserCreateOfferViewModel>getAllUsersWithNames();

    User getUserByUsername(String name);

}
