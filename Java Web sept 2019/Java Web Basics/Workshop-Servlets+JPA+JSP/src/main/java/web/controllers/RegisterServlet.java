package web.controllers;

import models.binding.UserRegisterBindingModel;
import services.interfaces.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class RegisterServlet  extends HttpServlet {
    private final UserService userService;

    @Inject
    public RegisterServlet(UserService userService) {
        this.userService = userService;
    }


        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegisterBindingModel model=new UserRegisterBindingModel(req.getParameter("username"),req.getParameter("password"),req.getParameter("email"));
        this.userService.registerUser(model);
        resp.sendRedirect("/users/login");
    }

}
