package bg.softuni.carshop.services.interfaces;

import bg.softuni.carshop.models.entity.Offer;
import bg.softuni.carshop.models.service.RegisterOfferServiceModel;
import bg.softuni.carshop.models.view.OfferDetailViewModel;

import java.util.List;

public interface OfferService {

    List<Offer> findAllOffers();
    void register(RegisterOfferServiceModel registerOfferServiceModel);

    OfferDetailViewModel getOfferDetailsById(long id);
}
