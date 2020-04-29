package services.interfaces;

import domain.view.UserViewModel;

import java.rmi.NoSuchObjectException;

public interface UserService {

    UserViewModel login(String username,String password) throws NoSuchObjectException;
}
