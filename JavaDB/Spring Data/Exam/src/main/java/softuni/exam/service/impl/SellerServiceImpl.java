package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.importDtos.ImportSellerDto;
import softuni.exam.models.dtos.importDtos.ImportSellerRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.interfaces.FileUtil;
import softuni.exam.util.interfaces.ValidationUtil;
import softuni.exam.util.interfaces.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil, FileUtil fileUtil, ModelMapper modelMapper, XMLParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count()>0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/xml/sellers.xml");
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb=new StringBuilder();
       ImportSellerRootDto importSellerRootDto=this.xmlParser.read(ImportSellerRootDto.class,"src/main/resources/files/xml/sellers.xml");
        for (ImportSellerDto sellerDto : importSellerRootDto.getSellers()) {
            Seller seller=this.modelMapper.map(sellerDto,Seller.class);

            if(this.validationUtil.isValid(seller)){

                sb.append(String.format("Successfully import seller %s - %s",seller.getLastName(),seller.getEmail()));
                this.sellerRepository.save(seller);
            }else{
                sb.append("Invalid seller");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
