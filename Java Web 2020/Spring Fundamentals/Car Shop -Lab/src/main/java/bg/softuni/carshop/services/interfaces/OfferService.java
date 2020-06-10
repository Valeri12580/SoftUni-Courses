package bg.softuni.carshop.services.interfaces;

import bg.softuni.carshop.models.entity.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> findAllOffers();
}
