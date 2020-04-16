package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeController extends HttpServlet {
    private List<Integer> integers;

    public HomeController() {
        this.integers = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number="";
        try {
           number= String.valueOf(this.integers.get(0));
        }catch (Exception e){
            number=null;
        }
        req.setAttribute("number",number);
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        integers.add(0,Integer.valueOf(req.getParameter("number")));

        resp.sendRedirect("/");
    }
}
