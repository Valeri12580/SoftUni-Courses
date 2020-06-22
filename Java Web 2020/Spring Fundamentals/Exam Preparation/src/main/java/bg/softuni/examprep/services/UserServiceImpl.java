package bg.softuni.examprep.services;

import bg.softuni.examprep.models.binding.UserRegisterBindingModel;
import bg.softuni.examprep.models.entities.User;
import bg.softuni.examprep.repositories.UserRepository;
import bg.softuni.examprep.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isUsernameFree(String username) {
        return this.userRepository.findByUsername(username)==null;
    }

    @Override
    public boolean isUserInDatabase(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username,password)!=null;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user=this.modelMapper.map(userRegisterBindingModel,User.class);

        this.userRepository.save(user);
    }
}
