package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.models.binding.RegisterOfferBindingModel;
import bg.softuni.carshop.models.enums.Category;
import bg.softuni.carshop.models.enums.Engine;
import bg.softuni.carshop.models.enums.Transmission;
import bg.softuni.carshop.models.service.RegisterOfferServiceModel;
import bg.softuni.carshop.models.view.OfferPreviewViewModel;
import bg.softuni.carshop.services.interfaces.ModelService;
import bg.softuni.carshop.services.interfaces.OfferService;
import bg.softuni.carshop.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private OfferService offerService;
    private ModelMapper modelMapper;
    private ModelService modelService;
    private UserService userService;

    @Autowired
    public OffersController(OfferService offerService, ModelMapper modelMapper, ModelService modelService, UserService userService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ModelAndView showAllCars(ModelAndView modelAndView) {
        List<OfferPreviewViewModel> offers = null;
        try {
            offers = Arrays.asList(this.modelMapper.map(this.offerService.findAllOffers(), OfferPreviewViewModel[].class));
            modelAndView.addObject("offers", offers);
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        }
        modelAndView.setViewName("all");


        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showOfferRegistrationPage(ModelAndView modelAndView) {

        modelAndView.addObject("engines", Engine.values());
        modelAndView.addObject("transmissions", Transmission.values());
        modelAndView.addObject("categories", Category.values());
        modelAndView.addObject("models", this.modelService.getAllModels());
        modelAndView.addObject("users", this.userService.getAllUsersWithNames());
        modelAndView.addObject("offer", new RegisterOfferBindingModel());
        modelAndView.setViewName("offer-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public String registerOffer(@ModelAttribute @Valid RegisterOfferBindingModel registerOfferBindingModel, BindingResult bindingResult){
        this.offerService.register(this.modelMapper.map(registerOfferBindingModel, RegisterOfferServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView offerDetails(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("offer",this.offerService.getOfferDetailsById(id));
        modelAndView.setViewName("details");
        return modelAndView;
    }
}
