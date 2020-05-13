package web.beans;


import domain.binding.UserRegisterBindingModel;
import services.interfaces.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.InvalidObjectException;

@Named
@RequestScoped
public class RegisterBean {

    private UserService userService;
    private UserRegisterBindingModel userRegisterBindingModel;
    private String errors;



    public RegisterBean() {
    }

    @Inject
    public RegisterBean(UserService userService,UserRegisterBindingModel userRegisterBindingModel) {
        this.userService = userService;
        this.userRegisterBindingModel=userRegisterBindingModel;
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }
    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }


   public String register(){
           this.userService.register(userRegisterBindingModel);
           return "login.xhtml?faces-redirect=true";

    }
}
