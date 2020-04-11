package app.web.servlets;

import app.util.FileUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HomeServlet extends HttpServlet {


    private FileUtil fileUtil;


    @Inject
    public HomeServlet(FileUtil fileUtil, EntityManager entityManager) {
        this.fileUtil = fileUtil;

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String html=fileUtil.readFile("D:\\Programming\\MyCode\\SoftUni courses\\Java Web sept 2019\\Java Web Basics\\Introduction to Java EE\\src\\main\\webapp\\views\\home.html");
        PrintWriter out=resp.getWriter();
        out.println(html);


    }
}
