package hiberspring.service.impl;

import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.dtos.importDtos.ImportEmployeeDto;
import hiberspring.domain.entities.dtos.importDtos.ImportEmployeeRootDto;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.interfaces.FileUtil;
import hiberspring.util.interfaces.ValidationUtil;
import hiberspring.util.interfaces.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final EmployeeCardServiceImpl cardService;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final ValidationUtil validationUtil;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, FileUtil fileUtil, ModelMapper modelMapper, XMLParser xmlParser, EmployeeCardServiceImpl cardService, BranchService branchService, EmployeeCardService employeeCardService, ValidationUtil validationUtil) {
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.cardService = cardService;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return this.fileUtil.readContent("src/main/resources/files/employees.xml");
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        ImportEmployeeRootDto importEmployeeRootDto = this.xmlParser.read(ImportEmployeeRootDto.class, "src/main/resources/files/employees.xml");

        for (ImportEmployeeDto employeeDto : importEmployeeRootDto.getEmployees()) {
            Employee employee = this.modelMapper.map(employeeDto, Employee.class);
            Branch branch = this.branchService.getBranchByName(employeeDto.getBranch());
            EmployeeCard employeeCard = this.employeeCardService.getEmployeeCardByNumber(employeeDto.getCard());
            employee.setBranch(branch);
            employee.setCard(employeeCard);

            if (this.validationUtil.isValid(employee)){

                this.employeeRepository.save(employee);
                sb.append(String.format("Successfully imported Employee %s %s.", employee.getFirstName(),employee.getLastName()));
            }else{
                sb.append("Error!Invalid data!");
            }
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder stringBuilder=new StringBuilder();
        List<Employee> employees=this.employeeRepository.exportData();
            employees.forEach(e->{
                stringBuilder.append(String.format("Name: %s %s\n" +
                        "Position: %s\n" +
                        "Card Number: %s\n" +
                        "-------------------------\n",e.getFirstName(),e.getLastName(),e.getPosition(),e.getCard().getNumber()));
            });

        return stringBuilder.toString();
    }
}
