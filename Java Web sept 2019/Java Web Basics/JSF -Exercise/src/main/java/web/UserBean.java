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

    public void saveEmp() throws IOException {
        this.employeeService.save(employeeBindingModel);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/views/index.xhtml");
    }

    public  String removeEmployeeById(String idString ){ int id =Integer.parseInt(idString);
      this.employeeService.removeEmployeeById(id);
        return "/faces/views/index.xhtml";
    }




}
