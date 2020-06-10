package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.Offer;
import bg.softuni.carshop.repositories.OfferRepository;
import bg.softuni.carshop.services.interfaces.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Offer> findAllOffers() {
        return this.offerRepository.findAllBy().orElseThrow(()->new EntityNotFoundException("There are no offers yet"));
    }
}
