package repositories;

import domain.entities.User;
import repositories.interfaces.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.UUID;


public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User entity) {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user ;
        try {
            user=this.entityManager.createQuery("SELECT u FROM User as u WHERE u.username=:username AND u.password=:password",User.class)
                    .setParameter("username",username).setParameter("password",password).getSingleResult();
        }catch(NoResultException noResultException){
            return null;
        }
        return user;
    }

    @Override
    public User getUserById(String id) {
        return this.entityManager.createQuery("SELECT u FROM User u WHERE u.id=:id",User.class).setParameter("id",id).getSingleResult();
    }
}
