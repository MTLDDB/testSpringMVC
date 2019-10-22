package controller;

import model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.AccountService;
import service.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LoginController implements Controller {
    private AccountService accountService;
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("test hello");
        accountService=new AccountServiceImpl();
        List<User> users=accountService.getUserByUserName(request.getParameter("name"));
        System.out.println(users.get(0).getPassword());
        return new ModelAndView("home").addObject("message","hello");
    }
}
