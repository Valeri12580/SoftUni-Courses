package web;

import models.binding.EmployeeBindingModel;
import models.view.EmployeeViewModel;
import services.interfaces.EmployeeService;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;


@Named("UserViewBean")
@RequestScoped
public class UserViewBean {
    private EmployeeService employeeService;
    private List<EmployeeViewModel> employeeViewModel;

    public UserViewBean() {
    }

    @Inject
    public UserViewBean(EmployeeService employeeService) {
        this.employeeService = employeeService;


    }

    @PostConstruct
    public void init() {
        this.employeeViewModel = this.employeeService.getAllEmployees();
    }


    public List<EmployeeViewModel> getEmployeeViewModel() {
        return this.employeeViewModel;
    }

    public void setEmployeeViewModel(List<EmployeeViewModel> employeeViewModel) {
        this.employeeViewModel = employeeViewModel;
    }


}
