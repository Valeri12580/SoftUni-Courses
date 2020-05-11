package repositories;

import domain.entities.Job;
import repositories.interfaces.JobRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class JobRepositoryImpl implements JobRepository {
    private EntityManager entityManager;

    @Inject
    public JobRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Job entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(String s) {

    }
}
