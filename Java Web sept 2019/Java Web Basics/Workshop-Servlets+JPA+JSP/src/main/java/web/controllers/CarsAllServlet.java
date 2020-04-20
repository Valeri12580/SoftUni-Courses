package web.controllers;

import models.view.CarViewModel;
import services.interfaces.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars/all")
public class CarsAllServlet extends HttpServlet {
    private CarService carService;

    @Inject
    public CarsAllServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarViewModel> result = carService.getAllCars();
        req.setAttribute("result",result);
        req.getRequestDispatcher("/cars-all.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
