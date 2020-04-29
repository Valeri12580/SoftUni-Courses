package repositories.interfaces;

import domain.entities.User;

public interface UserRepository  extends BaseRepository <User,String>{

    User getUserByUsernameAndPassword(String username,String password);

}
