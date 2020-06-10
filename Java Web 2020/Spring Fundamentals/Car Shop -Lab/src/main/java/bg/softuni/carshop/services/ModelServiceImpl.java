package bg.softuni.carshop.services;

import bg.softuni.carshop.models.service.RegisterModelServiceModel;
import bg.softuni.carshop.repositories.ModelRepository;
import bg.softuni.carshop.services.interfaces.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerModel(RegisterModelServiceModel registerModelServiceModel) {

    }
}
