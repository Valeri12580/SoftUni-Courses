package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository  extends JpaRepository<Offer,Long> {
}
