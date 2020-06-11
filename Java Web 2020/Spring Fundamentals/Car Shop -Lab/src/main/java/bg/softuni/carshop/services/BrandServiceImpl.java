package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.Brand;
import bg.softuni.carshop.models.service.RegisterBrandServiceModel;
import bg.softuni.carshop.repositories.BrandRepository;
import bg.softuni.carshop.services.interfaces.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl  implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerBrand(RegisterBrandServiceModel registerBrandServiceModel) {
        this.brandRepository.save(this.modelMapper.map(registerBrandServiceModel, Brand.class));
    }

    @Override
    public List<RegisterBrandServiceModel> getAllBrands() {
        return Arrays.asList(this.modelMapper.map(this.brandRepository.findAll(),RegisterBrandServiceModel[].class));
    }

    @Override
    public Brand getBrandByName(String name) {

        return this.brandRepository.findByName(name);
    }
}
