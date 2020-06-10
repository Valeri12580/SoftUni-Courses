package bg.softuni.carshop.services;

import bg.softuni.carshop.models.entity.Brand;
import bg.softuni.carshop.models.service.RegisterBrandServiceModel;
import bg.softuni.carshop.repositories.BrandRepository;
import bg.softuni.carshop.services.interfaces.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
