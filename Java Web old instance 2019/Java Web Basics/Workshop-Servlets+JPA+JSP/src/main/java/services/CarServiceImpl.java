package services;

import models.binding.CarCreateBindingModel;
import models.entities.Car;
import models.entities.User;
import models.view.CarViewModel;
import models.view.UserViewModel;
import org.modelmapper.ModelMapper;
import repositories.interfaces.CarRepository;
import repositories.interfaces.UserRepository;
import services.interfaces.CarService;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

public class CarServiceImpl implements CarService {
    private ModelMapper modelMapper;
    private CarRepository carRepository;
    private UserRepository userRepository;

    @Inject
    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository,UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.userRepository=userRepository;
    }

    @Override
    public void saveCar(CarCreateBindingModel carCreateBindingModel, UserViewModel userViewModel) {
        User user  =this.userRepository.getUserByUsername(userViewModel);
        Car car=this.modelMapper.map(carCreateBindingModel,Car.class);
        car.setUser(user);
        carRepository.saveCar(car);
    }

    @Override
    public List<CarViewModel> getAllCars() {
        Car[]cars=this.carRepository.getAllCars();
        CarViewModel[]result=this.modelMapper.map(cars,CarViewModel[].class);

        return Arrays.asList(result);
    }
}
