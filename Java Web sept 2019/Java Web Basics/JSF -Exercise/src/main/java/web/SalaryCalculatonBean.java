package web;

import services.interfaces.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named("salaryCalculation")
@RequestScoped
public class SalaryCalculatonBean {
    private EmployeeService employeeService;

    public SalaryCalculatonBean() {
    }

    @Inject
    public SalaryCalculatonBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public BigDecimal getAvgSalary(){

        return this.employeeService.getAverageSalary();
    }

    public BigDecimal getSumSalaryAllEmployees(){
        return  this.employeeService.getSalarySum();
    }
}
