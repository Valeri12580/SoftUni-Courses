package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.ImportEmployeeDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Position;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.PositionRepository;
import alararestaurant.util.interfaces.FileUtil;
import alararestaurant.util.interfaces.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PositionRepository positionRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.positionRepository = positionRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return  this.employeeRepository.count() > 0;

    }

    @Override
    public String readEmployeesJsonFile() throws IOException {

        return this.fileUtil.readContent("src/main/resources/files/employees.json");
    }

    @Override
    public String importEmployees(String employees) throws FileNotFoundException {
      StringBuilder sb=new StringBuilder();
        ImportEmployeeDto[] importEmployeeDtos=this.gson.fromJson(new FileReader("src/main/resources/files/employees.json"),ImportEmployeeDto[].class);

        for (ImportEmployeeDto employeeDto : importEmployeeDtos) {
                if(this.validationUtil.isValid(employeeDto)){

                    Employee employee=this.modelMapper.map(employeeDto,Employee.class);

                    if(this.positionRepository.getPositionByName(employeeDto.getPosition())==null){
                        Position position=new Position(employeeDto.getPosition());
                        employee.setPosition(position);
                    }else{
                        employee.setPosition(this.positionRepository.getPositionByName(employeeDto.getPosition()));
                    }


                    this.employeeRepository.save(employee);


                    sb.append(String.format("Record %s successfully imported.",employee.getName()));
                }else{
                    sb.append("Invalid data format.");
                }
                sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
