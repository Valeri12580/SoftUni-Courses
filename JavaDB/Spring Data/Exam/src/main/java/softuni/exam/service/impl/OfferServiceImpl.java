package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.importDtos.ImportOfferDto;
import softuni.exam.models.dtos.importDtos.ImportOfferRootDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Picture;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;
import softuni.exam.util.interfaces.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper, XMLParser xmlParser, SellerRepository sellerRepository, CarRepository carRepository, PictureRepository pictureRepository) {
        this.offerRepository = offerRepository;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count()>0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/xml/offers.xml");

    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb=new StringBuilder();
        ImportOfferRootDto importOfferRootDto=this.xmlParser.read(ImportOfferRootDto.class,"src/main/resources/files/xml/offers.xml");
        for (ImportOfferDto offerDto : importOfferRootDto.getOffers()) {
            Car car =this.carRepository.getCarById(offerDto.getCar().getId());
            Seller seller=this.sellerRepository.getSellerById(offerDto.getSeller().getId());
            Offer offer=this.modelMapper.map(offerDto,Offer.class);
            offer.setCar(car);
            offer.setSeller(seller);

            List<Picture> pictures=this.pictureRepository.getAllByCarId(car.getId());

            offer.setPictures(pictures);

            if(this.validationUtil.isValid(offer)){

                sb.append(String.format("Successfully import offer %s - %b",offer.getAddedOn().toString(),offer.isHasGoldStatus()));
                this.offerRepository.save(offer);
            }else{
                sb.append("Invalid offer");
            }

            sb.append(System.lineSeparator());

        }

        return sb.toString();
    }
}
