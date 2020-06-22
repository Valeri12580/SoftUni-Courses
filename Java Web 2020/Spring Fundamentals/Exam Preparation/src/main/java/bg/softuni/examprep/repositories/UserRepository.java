package bg.softuni.examprep.repositories;

import bg.softuni.examprep.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username,String password);
}
