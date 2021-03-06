package dao;



import model.Permission;
import model.Role;
import model.User;
import model.UserRole;

import java.util.List;

public interface BaseDao {

    List<Permission> findAllByHQL(String s, Object[] objects);

    List<User> findObjectByHQL(String s, Object[] objects);

    void saveAll(Object object);
    //save user
    void saveUser(User user);

    //save role
    void saveRole(Role role);

    //save UserRole
    void saveUserRole(UserRole userRole);

    //save Permission
    void savePermission(Permission permission);
}
