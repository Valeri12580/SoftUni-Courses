package services;

import models.binding.UserLoginBindingModel;
import models.binding.UserRegisterBindingModel;
import models.entities.User;
import models.view.UserViewModel;
import org.modelmapper.ModelMapper;
import repositories.interfaces.UserRepository;
import services.interfaces.UserService;

import javax.inject.Inject;
import java.rmi.NoSuchObjectException;


public class UserServiceImpl  implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user=this.modelMapper.map(userRegisterBindingModel,User.class);
        this.userRepository.save(user);


    }

    @Override
    public UserViewModel loginUser(UserLoginBindingModel userLoginBindingModel) throws NoSuchObjectException {
        User user = this.userRepository.getUserByUsernameAndPassword(userLoginBindingModel);
        if(user==null){
            throw new NoSuchObjectException("There is no user with the provided username and password");
        }else{
            return this.modelMapper.map(user,UserViewModel.class);
        }

    }
}
