package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.Brand;
import bg.softuni.carshop.models.entity.Model;
import bg.softuni.carshop.models.service.RegisterModelServiceModel;
import bg.softuni.carshop.models.view.ModelViewModel;
import bg.softuni.carshop.repositories.ModelRepository;
import bg.softuni.carshop.services.interfaces.BrandService;
import bg.softuni.carshop.services.interfaces.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapper modelMapper;
    private BrandService brandService;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    @Override
    public void registerModel(RegisterModelServiceModel registerModelServiceModel) {
        Brand brand=this.brandService.getBrandByName(registerModelServiceModel.getBrand());
        Model model=this.modelMapper.map(registerModelServiceModel,Model.class);
        model.setBrand(brand);
        this.modelRepository.save(model);

    }

    @Override
    public List<ModelViewModel> getAllModels() {

        return Arrays.asList(this.modelMapper.map(this.modelRepository.findAllBy(),ModelViewModel[].class));
    }

    @Override
    public Model getModelByName(String name) {
        return this.modelRepository.findByName(name);
    }
}
