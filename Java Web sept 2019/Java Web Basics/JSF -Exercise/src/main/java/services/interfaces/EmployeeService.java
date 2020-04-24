package services.interfaces;

import models.binding.EmployeeBindingModel;
import models.view.EmployeeViewModel;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeBindingModel employeeBindingModel);

    List<EmployeeViewModel> getAllEmployees();

}
