package app.service;

import app.domain.entities.Car;
import app.domain.models.binding.CarBindingModel;
import app.domain.models.service.CarServiceModel;
import app.domain.models.view.CarViewModel;
import app.service.interfaces.CarService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private ModelMapper modelMapper;
    private EntityManager entityManager;

    @Inject
    public CarServiceImpl(ModelMapper modelMapper, EntityManager entityManager) {
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
    }

    @Override
    public void addCar(CarBindingModel carBindingModel) {
        CarServiceModel carServiceModel=this.modelMapper.map(carBindingModel,CarServiceModel.class);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(this.modelMapper.map(carServiceModel, Car.class));

        this.entityManager.getTransaction().commit();


    }

    @Override
    public String getAllCars() {

        String cars=this.entityManager.createQuery("SELECT c FROM Car as c ",Car.class).getResultList().stream().map(e-> this.modelMapper.map(e, CarViewModel.class)).
                map(e->{
                    StringBuilder sb=new StringBuilder();
                    sb.append(String.format("<li class=\"d-flex justify-content-around\">\n" +
                                    "<div class=\"col-md-4 d-flex flex-column text-center mb-3\">\n" +
                                    "<h2 class=\"text-white text-center\">Brand: %s</h2>\n" +
                                    "<h4 class=\"text-white text-center\">Model: %s</h4>\n" +
                                    "<h4 class=\"text-white text-center\">Year: %d</h4>\n" +
                                    "<h4 class=\"text-white text-center\">Engine: %s</h4>\n" +
                                    "</div>\n" +
                                    "</li>\n",
                            e.getBrand(),e.getModel(),e.getYear(),e.getEngine()));
                    return sb.toString();
                }).collect(Collectors.joining());
        return cars;
    }
}
