package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.Picture;
import softuni.exam.domain.dtos.importDtos.ImportPictureDto;
import softuni.exam.domain.dtos.importDtos.ImportPictureRootDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;
import softuni.exam.util.interfaces.XMLParser;


import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;
import java.io.IOException;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final XMLParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, FileUtil fileUtil, XMLParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public String importPictures() throws IOException, JAXBException {
        ImportPictureRootDto importPictureRootDto=this.xmlParser.read(ImportPictureRootDto.class,"src/main/resources/files/xml/pictures.xml");
        for (ImportPictureDto importPictureDto : importPictureRootDto.getPictures()) {
            Picture picture=this.modelMapper.map(importPictureDto,Picture.class);
            if(this.validationUtil.isValid(picture)){
                this.pictureRepository.save(picture);
                System.out.println("Successfully imported picture - "+picture.getUrl());
            }else{
                System.out.println("Invalid picture");
            }

        }

       return "Successfully imported pictures";
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count()>0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/xml/pictures.xml");
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.findPictureByUrl(url);
    }
}
