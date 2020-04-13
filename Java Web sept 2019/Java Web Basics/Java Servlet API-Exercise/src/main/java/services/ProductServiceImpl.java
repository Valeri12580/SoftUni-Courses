package services;

import models.binding.ProductBindingModel;
import models.entities.Product;
import models.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import repositories.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveProduct(ProductBindingModel productBindingModel) {
        Product product=this.modelMapper.map(productBindingModel,Product.class);
        this.productRepository.save(product);

    }

    @Override
    public String getProducts() {
        List<ProductServiceModel> result = this.productRepository.getAll().stream()
                .map(e -> this.modelMapper.map(e, ProductServiceModel.class)).collect(Collectors.toList());
        StringBuilder sb=new StringBuilder();
        result.forEach(e->{
            sb.append(String.format("<li><a href=/details/%s>%s</a></li>\n",e.getName(),e.getName()));
        });

        return sb.toString();
    }

    @Override
    public ProductServiceModel getProductByName(String name) {
        return this.modelMapper.map(productRepository.getProductByName(name),ProductServiceModel.class);
    }
}
