package web.controllers;

import models.binding.ProductBindingModel;
import models.entities.Type;
import services.ProductService;
import utils.interfaces.FileUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    private ProductService productService;
    private FileUtil fileUtil;

    @Inject
    public CreateServlet(ProductService productService, FileUtil fileUtil) {
        this.productService = productService;
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.fileUtil.readContent("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Java Servlet API-Exercise\\src\\main\\webapp\\view\\create.html"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductBindingModel productBindingModel=new ProductBindingModel(req.getParameter("name"),
                req.getParameter("description"), Type.valueOf(req.getParameter("type")));

        this.productService.saveProduct(productBindingModel);
        resp.sendRedirect("/");
    }
}
