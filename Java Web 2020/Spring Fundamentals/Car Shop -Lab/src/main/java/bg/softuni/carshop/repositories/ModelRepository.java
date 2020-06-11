package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findAllBy();
    Model findByName(String name);
}
