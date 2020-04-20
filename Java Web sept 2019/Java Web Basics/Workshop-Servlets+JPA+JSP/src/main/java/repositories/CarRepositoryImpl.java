package repositories;

import models.entities.Car;
import repositories.interfaces.CarRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CarRepositoryImpl implements CarRepository {
    private final EntityManager entityManager;

    @Inject
    public CarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCar(Car car) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(car);
        entityManager.getTransaction().commit();
    }

    @Override
    public Car[] getAllCars() {
        return this.entityManager.createQuery("SELECT c FROM Car c",Car.class).getResultList().toArray(Car[]::new);
    }
}
