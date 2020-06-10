package bg.softuni.carshop.repositories;

import bg.softuni.carshop.models.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfferRepository  extends JpaRepository<Offer,Long> {


    Optional<List<Offer>>findAllBy();
}
