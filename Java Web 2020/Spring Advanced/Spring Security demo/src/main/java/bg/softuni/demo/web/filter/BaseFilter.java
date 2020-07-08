package bg.softuni.demo.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter( "/home")
public class BaseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request=(HttpServletRequest)servletRequest;

        System.out.println(String.format("Resource %s - User %s",request.getRequestURI(), request.getSession().getAttribute("username")));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
