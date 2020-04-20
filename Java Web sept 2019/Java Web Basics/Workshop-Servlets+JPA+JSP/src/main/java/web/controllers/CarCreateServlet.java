package web.controllers;

import models.binding.CarCreateBindingModel;
import models.view.UserViewModel;

import services.interfaces.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars/create")
public class CarCreateServlet extends HttpServlet {

   private CarService carService;

@Inject
    public CarCreateServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/cars-create.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarCreateBindingModel carCreateBindingModel=new CarCreateBindingModel(req.getParameter("brand")
        ,req.getParameter("model"),Integer.parseInt(req.getParameter("year")),req.getParameter("engine"));

        UserViewModel userViewModel=(UserViewModel)req.getSession().getAttribute("user");
        carService.saveCar(carCreateBindingModel,userViewModel);

        resp.sendRedirect("/cars/all");
    }


}
