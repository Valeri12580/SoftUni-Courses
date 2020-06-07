package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
