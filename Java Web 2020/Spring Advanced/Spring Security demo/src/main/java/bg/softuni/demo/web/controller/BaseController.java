package bg.softuni.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class BaseController {
    @GetMapping("/index")

    public String index(){
        return "index";
    }

    @GetMapping("/home")
    @ResponseBody
    public ModelAndView home(HttpSession session, Principal principal, ModelAndView mv){
        mv.addObject("user",principal.getName());
        mv.setViewName("home");
        return mv;
    }





}
