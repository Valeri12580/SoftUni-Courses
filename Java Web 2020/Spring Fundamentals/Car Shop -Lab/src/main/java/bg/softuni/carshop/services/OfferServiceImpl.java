package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.Model;
import bg.softuni.carshop.models.entity.Offer;
import bg.softuni.carshop.models.entity.User;
import bg.softuni.carshop.models.service.RegisterOfferServiceModel;
import bg.softuni.carshop.models.view.OfferDetailViewModel;
import bg.softuni.carshop.repositories.OfferRepository;
import bg.softuni.carshop.services.interfaces.ModelService;
import bg.softuni.carshop.services.interfaces.OfferService;
import bg.softuni.carshop.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private OfferRepository offerRepository;
    private ModelService modelService;
    private UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, UserService userService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Offer> findAllOffers() {
        return this.offerRepository.findAllBy().orElseThrow(()->new EntityNotFoundException("There are no offers yet"));
    }

    @Override
    public void register(RegisterOfferServiceModel registerOfferServiceModel) {
        Offer offer=this.modelMapper.map(registerOfferServiceModel,Offer.class);
        User user=this.userService.getUserByUsername(registerOfferServiceModel.getSellerUsername());
        Model model=this.modelService.getModelByName(registerOfferServiceModel.getModel());

        offer.setSeller(user);
        offer.setModel(model);

        this.offerRepository.save(offer);
    }

    @Override
    public OfferDetailViewModel getOfferDetailsById(long id) {
        return this.modelMapper.map(this.offerRepository.findById(id),OfferDetailViewModel.class);
    }
}
