package app.web.servlets;

import app.domain.entities.Car;
import app.domain.models.binding.CarBindingModel;
import app.service.interfaces.CarService;
import app.util.FileUtil;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {


    private FileUtil fileUtil;
    private CarService carService;

    @Inject
    public CreateServlet(FileUtil fileUtil, CarService carService) {
        this.fileUtil = fileUtil;
        this.carService = carService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html=fileUtil.readFile("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Introduction to Java EE\\src\\main\\webapp\\views\\create.html");
        PrintWriter out=resp.getWriter();
        out.println(html);
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        int year = Integer.parseInt(req.getParameter("year"));
        String engine = req.getParameter("engine");
        CarBindingModel carBindingModel=new CarBindingModel(brand,year,engine,model);
        carService.addCar(carBindingModel);




        resp.sendRedirect("/all ");
    }
}
