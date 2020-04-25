package services;

import models.binding.EmployeeBindingModel;
import models.entities.Employee;
import models.view.EmployeeViewModel;
import org.modelmapper.ModelMapper;
import repositories.EmployeeRepository;
import services.interfaces.EmployeeService;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(EmployeeBindingModel employeeBindingModel) {
        Employee employee=this.modelMapper.map(employeeBindingModel,Employee.class);
        this.employeeRepository.save(employee);
    }


    @Override
    public List<EmployeeViewModel> getAllEmployees() {
        List<EmployeeViewModel>result=this.employeeRepository.getAllEmployees().stream().map(e-> this.modelMapper.map(e,EmployeeViewModel.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void removeEmployeeById(int id) {
        this.employeeRepository.removeEmployeeById(id);
    }

    @Override
    public BigDecimal getAverageSalary() {
        return this.employeeRepository.getAverageSalary();
    }

    @Override
    public BigDecimal getSalarySum() {
        return this.employeeRepository.getSalarySum();
    }
}
