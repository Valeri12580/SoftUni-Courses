package bg.softuni.carshop.services.interfaces;

import bg.softuni.carshop.models.entity.Model;
import bg.softuni.carshop.models.service.RegisterModelServiceModel;
import bg.softuni.carshop.models.view.ModelViewModel;

import java.util.List;

public interface ModelService {
    void registerModel(RegisterModelServiceModel registerModelServiceModel);

    List<ModelViewModel> getAllModels();

    Model getModelByName(String name);
}
