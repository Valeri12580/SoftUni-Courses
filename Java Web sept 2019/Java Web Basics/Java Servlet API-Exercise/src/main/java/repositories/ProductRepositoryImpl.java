package repositories;

import models.entities.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {


    private EntityManager entityManager;

    @Inject
    public ProductRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("servlet_exercise").createEntityManager();;
    }



    @Override
    public  void save(Product item) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(item);
        this.entityManager.getTransaction().commit();

    }

    @Override
    public List<Product> getAll() {
        return this.entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product getProductByName(String name) {
        return this.entityManager.createQuery("SELECT p FROM Product p WHERE p.name=:name",Product.class)
                .setParameter("name",name).getSingleResult();
    }
}
