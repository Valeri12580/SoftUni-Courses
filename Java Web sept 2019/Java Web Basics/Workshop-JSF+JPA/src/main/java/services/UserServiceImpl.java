package services;

import domain.entities.User;
import domain.view.UserViewModel;
import org.modelmapper.ModelMapper;
import repositories.interfaces.UserRepository;
import services.interfaces.UserService;

import javax.inject.Inject;
import java.rmi.NoSuchObjectException;

public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Inject
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserViewModel login(String username,String password) throws NoSuchObjectException {
        User user = this.userRepository.getUserByUsernameAndPassword(username, password);
        if (user == null) {
            throw new NoSuchObjectException("There is no user with the provided username or password");
        }else{
          return  this.modelMapper.map(user,UserViewModel.class);
        }

    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
