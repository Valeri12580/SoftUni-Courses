package repositories.interfaces;

import models.entities.Car;

public interface CarRepository {
    void saveCar(Car car);

    Car[] getAllCars();

}
