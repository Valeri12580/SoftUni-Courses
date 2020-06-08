package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private OfferRepository offerRepository;

    @Autowired
    public CarsController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/all")
    public ModelAndView showAllCars(ModelAndView modelAndView){
        modelAndView.setViewName("all");
        modelAndView.addObject("offers",this.offerRepository.findAll());

        return modelAndView;
    }
}
