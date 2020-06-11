package bg.softuni.carshop.services.interfaces;

import bg.softuni.carshop.models.entity.Brand;
import bg.softuni.carshop.models.service.RegisterBrandServiceModel;

import java.util.List;

public interface BrandService {
    void registerBrand(RegisterBrandServiceModel registerUserServiceModel);

    List<RegisterBrandServiceModel>getAllBrands();

    Brand getBrandByName(String name);
}
