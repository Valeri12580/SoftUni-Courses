package app.config;

import app.util.FileUtil;
import app.util.FileUtilImpl;
import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationBeanConfiguration {


    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager(){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("intro_ee");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
