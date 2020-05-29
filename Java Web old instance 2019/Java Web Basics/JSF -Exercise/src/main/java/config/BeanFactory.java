package config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class BeanFactory {

    @Produces
    public  EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("jsf_exercise").createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
