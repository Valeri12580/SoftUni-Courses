package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
