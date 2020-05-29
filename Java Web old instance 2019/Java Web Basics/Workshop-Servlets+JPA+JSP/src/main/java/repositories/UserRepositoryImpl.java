package repositories;

import models.binding.UserLoginBindingModel;
import models.entities.User;
import models.view.UserViewModel;
import repositories.interfaces.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.Optional;


public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUserByUsernameAndPassword(UserLoginBindingModel userLoginBindingModel) {
        User fetchedUser = this.entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password", User.class)
                .setParameter("username", userLoginBindingModel.getUsername())
                .setParameter("password", userLoginBindingModel.getPassword()).getResultStream().findFirst().orElse(null);
        return fetchedUser;

    }

    @Override
    public User getUserByUsername(UserViewModel userViewModel) {
        User fetchedUser = this.entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class)
                .setParameter("username", userViewModel.getUsername()).getResultStream().findFirst().orElse(null);
        return fetchedUser;
    }
}
