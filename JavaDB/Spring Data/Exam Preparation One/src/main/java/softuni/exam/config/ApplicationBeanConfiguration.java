package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.util.FileUtilImpl;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XMLParserImpl;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;
import softuni.exam.util.interfaces.XMLParser;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }


    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public XMLParser xmlParser (){
        return new XMLParserImpl();
    }

    @Bean
    public FileUtil fileUtil(){
        return  new FileUtilImpl();
    }

    @Bean
    public StringBuilder stringBuilder(){
        return  new StringBuilder();
    }
}
