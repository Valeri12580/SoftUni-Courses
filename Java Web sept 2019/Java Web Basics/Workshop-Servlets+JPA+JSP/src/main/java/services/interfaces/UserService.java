package services.interfaces;

import models.binding.UserLoginBindingModel;
import models.binding.UserRegisterBindingModel;
import models.view.UserViewModel;

import java.rmi.NoSuchObjectException;

public interface UserService {

    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserViewModel loginUser(UserLoginBindingModel userLoginBindingModel) throws NoSuchObjectException;
}
