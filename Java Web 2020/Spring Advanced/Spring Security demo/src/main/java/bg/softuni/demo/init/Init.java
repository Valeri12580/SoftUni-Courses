package bg.softuni.demo.init;

import bg.softuni.demo.entities.Role;
import bg.softuni.demo.repositories.RoleRepository;
import bg.softuni.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public Init(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.roleRepository.count()<1){
            Role admin=new Role();
            admin.setRole("ADMIN");

            Role user=new Role();
            user.setRole("USER");


            roleRepository.save(admin);
            roleRepository.save(user);

        }
    }
}
