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
    public UserViewModel login(UserLoginBindingModel userLoginBindingModel) throws NoSuchObjectException {
        User user = this.userRepository.getUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());
        if (user == null) {
            throw new NoSuchObjectException("There is no user with the provided username or password");
        } else {
            return this.modelMapper.map(user, UserViewModel.class);
        }

    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) throws InvalidObjectException {
        User user = this.modelMapper.map(userRegisterBindingModel, User.class);
        if (this.validationUtil.isValid(user)) {
            this.userRepository.save(user);
        } else {
            StringBuilder sb = new StringBuilder();
            this.validationUtil.getViolations(user).forEach(e -> {
                sb.append(e.getMessage()).append(System.lineSeparator());
            });
            throw new InvalidObjectException(sb.toString());
        }


    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.getUserById(id);
    }


}
