package app.service.interfaces;

import app.domain.models.binding.CarBindingModel;

import app.domain.models.view.CarViewModel;

import java.util.List;

public interface CarService {
    void addCar(CarBindingModel carBindingModel);

   String getAllCars();
}
