package web;

import models.binding.EmployeeBindingModel;
import services.interfaces.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named("UserRegistrationBean")
@RequestScoped
public class UserRegistrationBean {
    private EmployeeBindingModel employeeBindingModel;
    private EmployeeService employeeService;

    public UserRegistrationBean() {
    }

    @Inject
    public UserRegistrationBean(EmployeeBindingModel employeeBindingModel, EmployeeService employeeService) {
        this.employeeBindingModel = employeeBindingModel;
        this.employeeService = employeeService;
    }

    public EmployeeBindingModel getEmployeeBindingModel() {
        return employeeBindingModel;
    }

    public void setEmployeeBindingModel(EmployeeBindingModel employeeBindingModel) {
        this.employeeBindingModel = employeeBindingModel;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String saveEmp() throws IOException {
        this.employeeService.save(employeeBindingModel);

        return "/views/index.xhtml";
    }
}
