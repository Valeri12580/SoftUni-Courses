package services;

import domain.binding.UserLoginBindingModel;
import domain.binding.UserRegisterBindingModel;
import domain.entities.User;
import domain.view.UserViewModel;
import org.modelmapper.ModelMapper;
import repositories.interfaces.UserRepository;
import services.interfaces.UserService;
import utils.ValidationUtilImpl;

import javax.inject.Inject;
import java.io.InvalidObjectException;
import java.rmi.NoSuchObjectException;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private ValidationUtilImpl validationUtil;

    @Inject
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ValidationUtilImpl validationUtil) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public UserViewModel login(UserLoginBindingModel userLoginBindingModel) {
        User user = this.userRepository.getUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());

        return this.modelMapper.map(user, UserViewModel.class);


    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = this.modelMapper.map(userRegisterBindingModel, User.class);
        this.userRepository.save(user);


    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.getById(id);
    }


}
