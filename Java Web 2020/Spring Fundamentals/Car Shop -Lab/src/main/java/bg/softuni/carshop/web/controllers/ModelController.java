package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.models.binding.RegisterModelBindingModel;
import bg.softuni.carshop.services.interfaces.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    private ModelMapper modelMapper;

    @Autowired
    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public ModelAndView getModelPage(ModelAndView modelAndView){
        modelAndView.setViewName("model-add");
        modelAndView.addObject("model",new RegisterModelBindingModel());
        return modelAndView;
    }
}
