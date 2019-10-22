package controller;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller{
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
       System.out.println("username");
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}