package controller.loginController;

import dao.BaseDaoIml;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.AccountService;
import service.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LoginController implements Controller {
    @Autowired
    private AccountService accountService;
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("test hello");

        String username=request.getParameter("username");
        System.out.println(username);
       /* ApplicationContext APPLICATION_CONTEXT1=new ClassPathXmlApplicationContext("file:E:\\testSpringMVC\\web\\WEB-INF\\applicationContext.xml");
        accountService=APPLICATION_CONTEXT1.getBean(AccountServiceImpl.class);*/
        List<User> users=accountService.getUserByUserName("admin");
        System.out.println(users.get(0).getPassword());
        return new ModelAndView("home").addObject("message","hello");
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
}
