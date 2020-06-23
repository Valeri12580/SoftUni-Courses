package bg.softuni.examprep.repositories;

import bg.softuni.examprep.models.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {

    Item findByName(String name);
}
