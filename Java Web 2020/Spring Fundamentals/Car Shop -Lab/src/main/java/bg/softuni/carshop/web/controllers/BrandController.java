package bg.softuni.carshop.web.controllers;

import bg.softuni.carshop.models.binding.RegisterBrandBindingModel;
import bg.softuni.carshop.models.service.RegisterBrandServiceModel;
import bg.softuni.carshop.services.interfaces.BrandService;
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
@RequestMapping("/brands")
public class BrandController {
    private BrandService brandService;
    private ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public ModelAndView getBrandPage(ModelAndView mv){
        mv.setViewName("brand-add");
        mv.addObject("brand",new RegisterBrandBindingModel());
        return mv;
    }

    @PostMapping("/add")
    public String registerBrand(@ModelAttribute @Valid RegisterBrandBindingModel registerBrandBindingModel , BindingResult bindingResult){
        this.brandService.registerBrand(this.modelMapper.map(registerBrandBindingModel, RegisterBrandServiceModel.class));

        /*
        if(error)
        same page
        else
        home
         */
        return "redirect:/";
    }
}
