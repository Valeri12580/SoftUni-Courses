package web;

import services.interfaces.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("UserRemoveBean")
@RequestScoped
public class UserRemoveBean {

    private EmployeeService employeeService;

    public UserRemoveBean() {
    }

    @Inject
    public UserRemoveBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public String removeEmployeeById(String idString) {
        int id = Integer.parseInt(idString);
        this.employeeService.removeEmployeeById(id);
        return "/views/index.xhtml";
    }
}
