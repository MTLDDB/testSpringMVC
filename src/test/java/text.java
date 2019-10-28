import dao.BaseDao;
import dao.BaseDaoIml;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.AccountServiceImpl;
import service.RegisterService;
import service.RegisterServiceImpl;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class text {

    private AccountService accountService;
    private RegisterService registerService;
    private BaseDao dao;
    public static void main(String[] args) {

        text text=new text();
        text.test1();
    }
    void test1() {
     /*   ApplicationContext APPLICATION_CONTEXT1=new ClassPathXmlApplicationContext("file:E:\\testSpringMVC\\web\\WEB-INF\\applicationContext.xml");
       accountService=APPLICATION_CONTEXT1.getBean(AccountServiceImpl.class);
       // registerService=APPLICATION_CONTEXT1.getBean(RegisterServiceImpl.class);
        dao=APPLICATION_CONTEXT1.getBean(BaseDaoIml.class);
        String s=accountService.getUserByUserName("admin").get(0).getPassword();
        System.out.println(s);
        User user=new User();
        user.setName("testT");
        user.setPassword("TEST");
        dao.saveUser(user);

       // registerService.saveUser(user);
        String ss=dao.findObjectByHQL("FROM User WHERE name = ?", new Object[] {"test"}).get(0).getPassword();
        //String ss=accountService.getUserByUserName("testT").get(0).getPassword();
        System.out.println(ss);*/

    }


}
