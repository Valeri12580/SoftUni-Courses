package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.UserRole;
import bg.softuni.carshop.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByRole(Role role);
}
