package app.web.servlets;

import app.service.interfaces.CarService;
import app.util.FileUtil;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/all")
public class AllServlet extends HttpServlet {

    private FileUtil fileUtil;
   private CarService carService;



    @Inject
    public AllServlet(FileUtil fileUtil, CarService carService) {
        this.fileUtil = fileUtil;
        this.carService = carService;

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String html=fileUtil.readFile("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Introduction to Java EE\\src\\main\\webapp\\views\\all.html")
               .replace("{{replace}}",this.carService.getAllCars()) ;


        PrintWriter out=resp.getWriter();
        out.println(html);


    }
}
