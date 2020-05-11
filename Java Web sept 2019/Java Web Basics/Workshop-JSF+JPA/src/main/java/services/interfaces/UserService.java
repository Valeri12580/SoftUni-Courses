package services.interfaces;

import domain.binding.UserLoginBindingModel;
import domain.binding.UserRegisterBindingModel;
import domain.entities.User;
import domain.view.UserViewModel;

import java.io.InvalidObjectException;
import java.rmi.NoSuchObjectException;
import java.util.UUID;

public interface UserService {

    UserViewModel login(UserLoginBindingModel userLoginBindingModel) throws NoSuchObjectException;

    void register(UserRegisterBindingModel userRegisterBindingModel) throws InvalidObjectException;

    User getUserById(String id );



}
