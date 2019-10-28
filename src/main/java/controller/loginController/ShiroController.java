package controller.loginController;

import model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;


@Controller
    @RequestMapping(value = "shiro")
    public class ShiroController {
        // 处理用户业务类
        @Autowired
        private AccountService accountService;

        @RequestMapping("success")
        private String success(){
            return "success";
        }
        @RequestMapping("index")
        private String index(){
            return "login";
        }
        @RequestMapping({"toLogin","403.do"})
        private ModelAndView tologin(HttpServletRequest request){
            ModelAndView mav = new ModelAndView();
            mav.setViewName("login");
            mav.addObject("message",request.getParameter("message"));
            return mav;
        }
        @RequestMapping("jump")
        private String jump(){
            return "home";
        }
        @RequestMapping("test")
        private String test(){
            return "home";
        }
        /*   *//***
         * 跳转到登录页面
         *
         * @return
         *//*
    @RequestMapping(value = "toLogin")
    public String toLogin() {
        // 跳转到/page/login.jsp页面
        return "login";
    }
*/
        @RequestMapping(value = "login")
        public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String passwordOld) {
            String password=UUID.nameUUIDFromBytes(passwordOld.getBytes()).toString().replace("-","");
            System.out.println(password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException ice) {
                // 捕获密码错误异常
                ModelAndView mv = new ModelAndView("error");
                mv.addObject("message", "password error!");
                return mv;
            } catch (UnknownAccountException uae) {
                // 捕获未知用户名异常
                ModelAndView mv = new ModelAndView("error");
                mv.addObject("message", "username error!");
                return mv;
            } catch (ExcessiveAttemptsException eae) {
                // 捕获错误登录过多的异常
                ModelAndView mv = new ModelAndView("error");
                mv.addObject("message", "times error");
                return mv;
            }
            List<User> user = accountService.getUserByUserName(username);
            subject.getSession().setAttribute("user", user);
            return new ModelAndView("success");
        }
       /* public ModelAndView Login(HttpServletRequest request) {
            ModelAndView mav = new ModelAndView();
            System.out.println("testZ");
            System.out.println(request.getParameter("username"));
            String username=request.getParameter("username");
            System.out.println(request.getParameter("password"));
            String password=request.getParameter("password");
            List<User> user = accountService.getUserByUserName(username);
            System.out.println(user.size());
            if (user == null||user.size()==0) {
                mav.setViewName("redirect:toLogin");
                mav.addObject("message", "用户不存在");
                return mav;
            }else if (!user.get(0).getPassword().equals(password)) {
                mav.setViewName("redirect:toLogin");
                mav.addObject("message", "账号密码错误");
                return mav;
            }
            SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
            // 登录后存放进shiro token
            UsernamePasswordToken token = new UsernamePasswordToken(user.get(0).getName(), user.get(0).getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            // 登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接。
            mav.setViewName("home");
            return mav;
        }*/
    }

