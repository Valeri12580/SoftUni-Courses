package web;

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
    private String username;
    private String password;

    public LoginBean() {

    }

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loginUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UserViewModel userViewModel = this.userService.login(username, password);
            context.getExternalContext().getSessionMap().put("user", userViewModel);

        } catch (NoSuchObjectException e) {
            System.out.println(e.getMessage());
        }

    }


}
