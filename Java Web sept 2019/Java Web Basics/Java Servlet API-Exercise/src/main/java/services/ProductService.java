package services;

import models.binding.ProductBindingModel;
import models.service.ProductServiceModel;

public interface ProductService {
    void saveProduct(ProductBindingModel productBindingModel);
    String getProducts();

    ProductServiceModel getProductByName(String name);
}
