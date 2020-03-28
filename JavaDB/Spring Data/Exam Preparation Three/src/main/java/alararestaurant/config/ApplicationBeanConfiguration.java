package alararestaurant.config;

import alararestaurant.util.FileUtilImpl;
import alararestaurant.util.ValidationUtilImpl;
import alararestaurant.util.XMLParserImpl;
import alararestaurant.util.interfaces.FileUtil;
import alararestaurant.util.interfaces.ValidationUtil;
import alararestaurant.util.interfaces.XMLParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil(){
        return new FileUtilImpl();
    }

    @Bean
    public Gson gson() {
        // TODO : Implement me
       return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
//
    }

    @Bean
    public ValidationUtil validationUtil() {
        // TODO : Implement me
        return new ValidationUtilImpl();
//
    }

    @Bean
    public ModelMapper modelMapper() {
        // TODO : Implement me
       return  new ModelMapper();
    }

    @Bean
    public XMLParser xmlParser(){
        return  new XMLParserImpl();
    }
}
