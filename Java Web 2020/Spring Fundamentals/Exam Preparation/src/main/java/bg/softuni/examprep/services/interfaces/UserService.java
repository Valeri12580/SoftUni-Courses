package bg.softuni.examprep.services.interfaces;

import bg.softuni.examprep.models.binding.UserRegisterBindingModel;

public interface UserService {

     boolean isUsernameFree(String username);

     boolean isUserInDatabase(String username, String password);

     void register(UserRegisterBindingModel userRegisterBindingModel);
}
