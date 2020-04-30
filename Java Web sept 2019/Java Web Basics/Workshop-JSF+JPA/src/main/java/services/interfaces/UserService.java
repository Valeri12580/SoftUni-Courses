package services.interfaces;

import domain.binding.UserLoginBindingModel;
import domain.binding.UserRegisterBindingModel;
import domain.view.UserViewModel;

import java.io.InvalidObjectException;
import java.rmi.NoSuchObjectException;

public interface UserService {

    UserViewModel login(UserLoginBindingModel userLoginBindingModel) throws NoSuchObjectException;

    void register(UserRegisterBindingModel userRegisterBindingModel) throws InvalidObjectException;



}
