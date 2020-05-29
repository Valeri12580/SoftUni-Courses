package bg.example.exampreparation.services;

import bg.example.exampreparation.models.dtos.UserLoginDto;
import bg.example.exampreparation.models.dtos.UserRegisterDto;
import bg.example.exampreparation.models.dtos.UserViewModel;
import bg.example.exampreparation.models.entities.User;
import bg.example.exampreparation.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public void register(UserRegisterDto userRegisterDto){
        this.userRepository.save(this.modelMapper.map(userRegisterDto, User.class));
    }

    public UserViewModel login(UserLoginDto loginDto){

        UserViewModel userViewModel=this.modelMapper.map(this.userRepository.findUserByUsername(loginDto.getUsername()),UserViewModel.class);
        return userViewModel;
    }
}
