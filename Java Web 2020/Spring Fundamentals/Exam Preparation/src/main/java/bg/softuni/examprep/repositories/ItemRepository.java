package bg.softuni.examprep.repositories;

import bg.softuni.examprep.models.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
