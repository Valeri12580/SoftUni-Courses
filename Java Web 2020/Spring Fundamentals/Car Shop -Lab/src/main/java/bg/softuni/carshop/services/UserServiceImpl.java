package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.User;
import bg.softuni.carshop.models.enums.Role;
import bg.softuni.carshop.models.service.RegisterUserServiceModel;
import bg.softuni.carshop.repositories.RoleRepository;
import bg.softuni.carshop.repositories.UserRepository;
import bg.softuni.carshop.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(RegisterUserServiceModel registerUserServiceModel) {
        this.setRole(registerUserServiceModel);
        this.userRepository.save(this.modelMapper.map(registerUserServiceModel, User.class));

    }

    private void setRole(RegisterUserServiceModel registerUserServiceModel){
        if(this.userRepository.count()==0){
            registerUserServiceModel.setUserRole(this.roleRepository.findByRole(Role.ADMIN));

        }else{
            registerUserServiceModel.setUserRole(this.roleRepository.findByRole(Role.USER));

        }
    }
}
