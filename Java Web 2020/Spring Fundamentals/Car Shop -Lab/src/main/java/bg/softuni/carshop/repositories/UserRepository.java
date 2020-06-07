package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<User,Long> {
}
