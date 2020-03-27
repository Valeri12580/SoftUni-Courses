package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.dtos.importDtos.ImportCardsDto;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.interfaces.FileUtil;
import hiberspring.util.interfaces.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.employeeCardRepository = employeeCardRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/employee-cards.json");
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {
        ImportCardsDto[] importCardsDto = this.gson.fromJson(new FileReader("src/main/resources/files/employee-cards.json"), ImportCardsDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportCardsDto cardsDto : importCardsDto) {
            EmployeeCard employeeCard = this.modelMapper.map(cardsDto, EmployeeCard.class);


            try {
                this.validationUtil.isValid(employeeCard) ;

                this.employeeCardRepository.save(employeeCard);
                sb.append(String.format("Successfully imported Employee Card %s.", employeeCard.getNumber()));

            }catch (Exception e){

                sb.append("Error: Invalid data.");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public EmployeeCard getEmployeeCardByNumber(String number) {
      return   this.employeeCardRepository.findByNumber(number);
    }
}
