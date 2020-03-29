package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.importDtos.ImportPictureDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper, CarRepository carRepository) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count()>0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/json/pictures.json");
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb=new StringBuilder();
        ImportPictureDto[]importPictureDtos=this.gson.fromJson(new FileReader("src/main/resources/files/json/pictures.json"),ImportPictureDto[].class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (ImportPictureDto importPictureDto : importPictureDtos) {
            Car car =this.carRepository.getCarById(importPictureDto.getCar());

            Picture picture=this.modelMapper.map(importPictureDto,Picture.class);
            LocalDateTime localDateTime=LocalDateTime.parse(importPictureDto.getDateAndTime(),dtf);
            picture.setCar(car);
            picture.setDateAndTime(localDateTime);

            if (this.validationUtil.isValid(picture)) {
                this.pictureRepository.save(picture);
                sb.append(String.format("Successfully import picture - %s",picture.getName()));
            }else{
                sb.append("Invalid picture");
            }
            sb.append(System.lineSeparator());

        }


        return sb.toString();
    }
}
