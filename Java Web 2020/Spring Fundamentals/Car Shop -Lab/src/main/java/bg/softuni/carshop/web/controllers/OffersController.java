package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.models.entity.Offer;
import bg.softuni.carshop.models.view.OfferPreviewViewModel;
import bg.softuni.carshop.repositories.OfferRepository;
import bg.softuni.carshop.services.interfaces.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private OfferService offerService;
    private ModelMapper modelMapper;

    @Autowired
    public OffersController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ModelAndView showAllCars(ModelAndView modelAndView){
        List<OfferPreviewViewModel> offers=null;
        try{
            offers=Arrays.asList(this.modelMapper.map(this.offerService.findAllOffers(),OfferPreviewViewModel[].class));
            modelAndView.addObject("offers",offers);
        }catch (EntityNotFoundException e){
            System.err.println(e.getMessage());
        }
        modelAndView.setViewName("all");


        return modelAndView;
    }
}
