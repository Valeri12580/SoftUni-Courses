import org.modelmapper.ModelMapper;
import repositories.ProductRepository;
import repositories.ProductRepositoryImpl;
import services.ProductService;
import services.ProductServiceImpl;
import utils.FileUtilImpl;
import utils.interfaces.FileUtil;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class Config {




    @Produces
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }


}
