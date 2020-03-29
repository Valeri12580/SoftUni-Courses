package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.importDtos.ImportCarDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count()>0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/json/cars.json");

    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb=new StringBuilder();
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        ImportCarDto[] importCarDtos=this.gson.fromJson(new FileReader("src/main/resources/files/json/cars.json"),ImportCarDto[].class);

        for (ImportCarDto importCarDto : importCarDtos) {
            Car car =this.modelMapper.map(importCarDto,Car.class);
            LocalDate localDate=LocalDate.parse(importCarDto.getRegisteredOn(), dtf);
            car.setRegisteredOn(localDate);
            if(this.validationUtil.isValid(car)){
                this.carRepository.save(car);
                sb.append(String.format("Successfully imported car - %s - %s",car.getMake(),car.getModel()));
            }else{
                sb.append("Invalid car");
            }
            sb.append(System.lineSeparator());


        }
        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb=new StringBuilder();
        this.carRepository.getCarsOrderByPicturesCountThenByMake().forEach(e->{
            sb.append(String.format("Car make - %s, model - %s\n" +
                    "\tKilometers - %d\n" +
                    "\tRegistered on - %s\n" +
                    "\tNumber of pictures - %d\n",e.getMake(),e.getModel(),e.getKilometers(),e.getRegisteredOn().toString(),e.getPictures().size()));
        });

        return sb.toString();
    }
}
