package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.domain.entities.dtos.importDtos.ImportProductDto;
import hiberspring.domain.entities.dtos.importDtos.ImportProductsRootDto;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.interfaces.FileUtil;
import hiberspring.util.interfaces.ValidationUtil;
import hiberspring.util.interfaces.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;
    private final BranchService branchService;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XMLParser xmlParser;

    public ProductServiceImpl(ProductRepository productRepository,  BranchService branchService, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, XMLParser xmlParser) {
        this.productRepository = productRepository;
        this.branchService = branchService;

        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count()>0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/products.xml");
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        ImportProductsRootDto importProductsRootDto=this.xmlParser.read(ImportProductsRootDto.class,"src/main/resources/files/products.xml");

        StringBuilder sb=new StringBuilder();
        for (ImportProductDto productDto : importProductsRootDto.getProducts()) {
            Product product=this.modelMapper.map(productDto,Product.class);
            Branch branch=this.branchService.getBranchByName(productDto.getBranch());
            product.setBranch(branch);
            if(this.validationUtil.isValid(product)){
                this.productRepository.save(product);
                sb.append(String.format("Successfully imported Product %s.",product.getName()));
            }else{
                sb.append("Error: Invalid data.");
            }

            sb.append(System.lineSeparator());

        }

        return sb.toString();
    }
}
