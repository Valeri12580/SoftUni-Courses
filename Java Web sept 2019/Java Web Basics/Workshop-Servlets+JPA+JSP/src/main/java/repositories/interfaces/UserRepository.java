package repositories.interfaces;

import models.binding.UserLoginBindingModel;
import models.entities.User;
import models.view.UserViewModel;

public interface UserRepository {

    void save(User user);

    User getUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel);

    User getUserByUsername(UserViewModel userViewModel);
}
