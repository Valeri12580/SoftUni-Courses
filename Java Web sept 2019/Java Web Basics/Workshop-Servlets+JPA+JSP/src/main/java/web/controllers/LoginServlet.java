package web.controllers;

import models.binding.UserLoginBindingModel;
import models.entities.User;
import models.view.UserViewModel;
import services.interfaces.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.NoSuchObjectException;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {
        private UserService userService;

        @Inject
    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLoginBindingModel userLoginBindingModel=new UserLoginBindingModel(req.getParameter("username"),req.getParameter("password"));
        try {
            UserViewModel user= this.userService.loginUser(userLoginBindingModel);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/home");
        } catch (NoSuchObjectException e) {
            req.setAttribute("exception",e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
