package web.controllers;

import services.ProductService;
import utils.interfaces.FileUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {


    private ProductService productService;
    private FileUtil fileUtil;

    @Inject
    public HomeServlet(ProductService productService, FileUtil fileUtil) {
        this.productService = productService;
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.getWriter().println(
                this.fileUtil.readContent("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Java Servlet API-Exercise\\src\\main\\webapp\\view\\index.html").replace("{{replace}}",this.productService.getProducts()));
    }
}
