package web;

import services.interfaces.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named("SalaryCalculationBean")
@RequestScoped
public class SalaryCalculatonBean {

    private EmployeeService employeeService;

    public SalaryCalculatonBean() {
    }

    @Inject
    public SalaryCalculatonBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    public Double getSumSalaryAllEmployees(){
        return  this.employeeService.getSalarySum();
    }
    public Double getAverageSalary(){
        return this.employeeService.getAverageSalary();
    }
}
