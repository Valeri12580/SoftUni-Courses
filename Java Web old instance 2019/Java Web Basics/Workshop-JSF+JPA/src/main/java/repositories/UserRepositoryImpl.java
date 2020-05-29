package repositories;

import domain.entities.User;
import repositories.interfaces.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;



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
    public User getById(String s) {
        return this.entityManager.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class).setParameter("id", s).getSingleResult();
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = this.entityManager.createQuery("SELECT u FROM User as u WHERE u.username=:username AND u.password=:password", User.class)
                .setParameter("username", username).setParameter("password", password).getSingleResult();
        return user;
    }


}
