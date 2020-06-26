package bg.softuni.exampreptwo.services.interfaces;


import bg.softuni.exampreptwo.models.entity.User;
import bg.softuni.exampreptwo.models.service.UserRegisterServiceModel;

public interface UserService {

    void register(UserRegisterServiceModel user);

    boolean isCredentialsValid(String username, String password);
    User getUserByUsername(String username);
}
