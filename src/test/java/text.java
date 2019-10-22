import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.AccountServiceImpl;

public class text {

    private AccountService accountService;

    public static void main(String[] args) {

        text text=new text();
        text.test1();
    }
    void test1(){
        ApplicationContext APPLICATION_CONTEXT1=new ClassPathXmlApplicationContext("file:E:\\testSpringMVC\\web\\WEB-INF\\applicationContext.xml");
        accountService=APPLICATION_CONTEXT1.getBean(AccountServiceImpl.class);
        String s=accountService.getUserByUserName("admin").get(0).getPassword();
        System.out.println(s);
    }
}
