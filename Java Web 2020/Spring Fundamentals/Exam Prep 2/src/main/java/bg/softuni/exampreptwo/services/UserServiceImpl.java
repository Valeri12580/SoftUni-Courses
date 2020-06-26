package bg.softuni.exampreptwo.services;

import bg.softuni.exampreptwo.models.entity.User;
import bg.softuni.exampreptwo.models.service.UserRegisterServiceModel;
import bg.softuni.exampreptwo.repository.UserRepository;
import bg.softuni.exampreptwo.services.interfaces.UserService;
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
    public void register(UserRegisterServiceModel user) {
        User entity=this.modelMapper.map(user,User.class);
        this.userRepository.save(entity);
    }

    @Override
    public boolean isCredentialsValid(String username, String password){
        return this.userRepository.findByUsernameAndPassword(username,password)!=null;
    }

    @Override
    public User getUserByUsername(String username) {

        return this.userRepository.findByUsername(username);
    }
}
