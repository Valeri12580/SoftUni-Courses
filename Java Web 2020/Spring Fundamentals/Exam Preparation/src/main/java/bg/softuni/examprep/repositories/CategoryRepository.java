package bg.softuni.examprep.repositories;

import bg.softuni.examprep.models.entities.Category;
import bg.softuni.examprep.models.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findByType(CategoryType category);
}
