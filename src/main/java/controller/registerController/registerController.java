package controller.registerController;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RegisterService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("register")
public class registerController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("form")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        String description=request.getParameter("description");
        String url=request.getParameter("url");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        registerService.saveUser(user);
        ModelAndView mav=new ModelAndView();
        return  mav;
    }
}
