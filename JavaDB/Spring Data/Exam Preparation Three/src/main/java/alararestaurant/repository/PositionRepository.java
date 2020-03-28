package alararestaurant.repository;

import alararestaurant.domain.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {

    Position getPositionByName(String name);
}
