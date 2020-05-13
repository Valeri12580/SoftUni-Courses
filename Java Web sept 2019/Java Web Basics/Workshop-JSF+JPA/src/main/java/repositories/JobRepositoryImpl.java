package repositories;

import domain.entities.Job;
import repositories.interfaces.JobRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

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
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Job j WHERE j.id =:id").setParameter("id",s).executeUpdate();
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Job getById(String s) {

        return this.entityManager.createQuery("SELECT j FROM Job j WHERE j.id=:id",Job.class).setParameter("id",s).getSingleResult();
    }

    @Override
    public List<Job> getAllJobs() {
        return entityManager.createQuery("SELECT j FROM Job j ",Job.class).getResultList();
    }
}
