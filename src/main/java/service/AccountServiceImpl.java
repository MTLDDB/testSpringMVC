package service;

import dao.BaseDao;
import dao.BaseDaoIml;
import model.Permission;
import model.Role;
import model.User;
import model.UserRole;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {


    // 公共的数据库访问接口
    // 这里省略BaseDao dao的编写
    private BaseDao dao;
    /****
     * 通过用户名获取用户对象
     *
     * @param username
     * @return
     */
    public List<User> getUserByUserName(String username) {
        System.out.println("调用getName");
        List<User> users =  dao.findObjectByHQL("FROM User WHERE name = ?", new Object[] { username });
        return users;
    }

    public List<String> getPermissionsByUserName(String username) {
        return null;
    }

    /***
     * 通过用户名获取权限资源
     *
     * @param name
     * @return
     */
   /* public List<String> getPermissionsByUserName(String username) {
        System.out.println("调用");
        List<User> user = getUserByUserName(username);
        if (user == null) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        // System.out.println(user.getUserRoles().get(0).get);
       *//* for (UserRole userRole : user.getUserRoles()) {
            Role role = userRole.getRole();*//*
           // List<Permission> permissions = dao.findAllByHQL("FROM Permission WHERE roleId = ?", new Object[] { role.getId() });
//            for (Permission p : permissions) {
//                list.add(p.getUrl());
//            }
        }
        return list;
    }
*/
    public void setDao(BaseDaoIml dao) {
        this.dao = dao;
    }
}
