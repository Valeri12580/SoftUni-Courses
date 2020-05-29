package services.interfaces;

import domain.binding.UserLoginBindingModel;
import domain.binding.UserRegisterBindingModel;
import domain.entities.User;
import domain.view.UserViewModel;

public interface UserService {

    UserViewModel login(UserLoginBindingModel userLoginBindingModel);

    void register(UserRegisterBindingModel userRegisterBindingModel);

    User getUserById(String id );



}
