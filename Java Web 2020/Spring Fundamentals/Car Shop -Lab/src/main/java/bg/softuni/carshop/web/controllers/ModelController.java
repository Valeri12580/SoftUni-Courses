package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.models.binding.RegisterModelBindingModel;
import bg.softuni.carshop.models.service.RegisterModelServiceModel;
import bg.softuni.carshop.services.interfaces.BrandService;
import bg.softuni.carshop.services.interfaces.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    private ModelMapper modelMapper;
    private BrandService brandService;

    @Autowired
    public ModelController(ModelService modelService, ModelMapper modelMapper, BrandService brandService) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }


    @GetMapping("/add")
    public ModelAndView getModelPage(ModelAndView modelAndView) {
        modelAndView.setViewName("model-add");
        modelAndView.addObject("model", new RegisterModelBindingModel());
        modelAndView.addObject("brands", this.brandService.getAllBrands());
        return modelAndView;
    }

    @PostMapping("/add")
    public String createModel(@ModelAttribute @Valid RegisterModelBindingModel registerModelBindingModel, BindingResult bindingResult) {
        RegisterModelServiceModel registerModelServiceModel = this.modelMapper.map(registerModelBindingModel, RegisterModelServiceModel.class);
        this.modelService.registerModel(registerModelServiceModel);
        //if invalid-same page

        return "redirect:/";
    }
}
