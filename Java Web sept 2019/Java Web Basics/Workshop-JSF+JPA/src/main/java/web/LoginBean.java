package web;

import domain.binding.UserLoginBindingModel;
import domain.view.UserViewModel;
import services.interfaces.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.rmi.NoSuchObjectException;

@Named
@RequestScoped
public class LoginBean {

    private UserService userService;
    private UserLoginBindingModel userLoginBindingModel;
    private String errors;

    public LoginBean() {

    }

    @Inject
    public LoginBean(UserService userService, UserLoginBindingModel userLoginBindingModel) {
        this.userService = userService;
        this.userLoginBindingModel = userLoginBindingModel;
    }


    public UserLoginBindingModel getUserLoginBindingModel() {
        return userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String loginUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UserViewModel userViewModel = this.userService.login("","");
            context.getExternalContext().getSessionMap().put("user", userViewModel);

            return "/views/authenticated/home.xhtml?faces-redirect=true";

        } catch (NoSuchObjectException e) {
            this.errors = e.getMessage();
            return null;
        }

    }


}
