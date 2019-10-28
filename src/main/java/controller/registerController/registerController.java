package controller.registerController;


import model.Permission;
import model.Role;
import model.User;
import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RegisterService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("register")
public class registerController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("form")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String passwordMd5= UUID.nameUUIDFromBytes(password.getBytes()).toString().replace("-","");
        String roleString=request.getParameter("role");
        String description=request.getParameter("description");
        String url=request.getParameter("url");
        User user=new User();
      //  user.setUser_id(UUID.randomUUID().toString().replace("-",""));
        user.setName(name);
        user.setPassword(passwordMd5);

        Role role=new Role();
        //role.setRole_id(UUID.randomUUID().toString().replace("-",""));
        role.setName(roleString);
        role.setDescription(description);

        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

      /*  Permission permission=new Permission();
        permission.setUrl(url);
        permission.setRoleId(role.getId());*/
        registerService.saveUser(user);
        registerService.saveRole(role);
        registerService.saveUserRole(userRole);
        ModelAndView mav=new ModelAndView();
        return  mav;
    }
}
