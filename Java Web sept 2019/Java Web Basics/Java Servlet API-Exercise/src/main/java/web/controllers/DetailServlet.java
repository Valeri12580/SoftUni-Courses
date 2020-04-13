package web.controllers;


import models.service.ProductServiceModel;
import services.ProductService;
import utils.interfaces.FileUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details/Cigari")
public class DetailServlet extends HttpServlet {

    private ProductService productService;
    private FileUtil fileUtil;

    @Inject
    public DetailServlet(ProductService productService, FileUtil fileUtil) {
        this.productService = productService;
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getPathInfo().split("/")[1];
        ProductServiceModel result=this.productService.getProductByName(name);

        resp.getWriter().println(this.fileUtil.readContent("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Java Servlet API-Exercise\\src\\main\\webapp\\view\\detail.html")
                .replace("{{replace}}",
                        String.format("<h1>%s</h1>" +
                                "<p>%s</p>" +
                                "<p>%s</p>",result.getName(),result.getDescription(),result.getType().toString())));
    }
}
