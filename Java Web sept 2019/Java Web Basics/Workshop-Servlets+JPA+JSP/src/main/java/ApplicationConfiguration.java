import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class ApplicationConfiguration {
    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("web_workshop").createEntityManager();
    }


}
