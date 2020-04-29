package repositories;

import domain.entities.User;
import repositories.interfaces.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(String s) {

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
}
