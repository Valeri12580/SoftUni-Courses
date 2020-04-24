package web;

import models.binding.EmployeeBindingModel;
import models.view.EmployeeViewModel;
import services.interfaces.EmployeeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named("UserBean")
@RequestScoped
public class UserBean {
    private EmployeeService employeeService;
    private EmployeeBindingModel employeeBindingModel;
    private List<EmployeeViewModel> employeeViewModel;

    public UserBean() {
    }

    @Inject
    public UserBean(EmployeeService employeeService, EmployeeBindingModel employeeBindingModel) {
        this.employeeService = employeeService;
        this.employeeBindingModel = employeeBindingModel;


    }

    @PostConstruct
    public void init(){
        this.employeeViewModel=this.employeeService.getAllEmployees();
    }


    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeBindingModel getEmployeeBindingModel() {
        return employeeBindingModel;
    }

    public void setEmployeeBindingModel(EmployeeBindingModel employeeBindingModel) {
        this.employeeBindingModel = employeeBindingModel;
    }



    public List<EmployeeViewModel> getEmployeeViewModel() {
        return this.employeeViewModel;
    }

    public void setEmployeeViewModel(List<EmployeeViewModel> employeeViewModel) {
        this.employeeViewModel = employeeViewModel;
    }

    public void saveEmp(){
        this.employeeService.save(employeeBindingModel);
    }


}
