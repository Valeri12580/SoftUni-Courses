package services.interfaces;

import models.binding.CarCreateBindingModel;
import models.view.CarViewModel;
import models.view.UserViewModel;

import java.util.List;

public interface CarService {
    void saveCar(CarCreateBindingModel carCreateBindingModel, UserViewModel userViewModel);

    List<CarViewModel> getAllCars();
}
