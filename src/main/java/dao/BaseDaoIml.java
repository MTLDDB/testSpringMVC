package dao;

import model.Permission;
import model.Role;
import model.User;
import model.UserRole;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public class BaseDaoIml extends HibernateTemplate implements BaseDao {

    public List<Permission> findAllByHQL(String s, Object[] objects) {
        return (List<Permission>) find(s,objects);
    }

    public List<User> findObjectByHQL(String s, Object[] objects) {
        return (List<User>) find(s,objects);
    }

    public void saveAll(Object object) {
        save(object);
    }

    public void saveUser(User user) {
        System.out.println(user.getPassword());
        save(user);
    }

    public void saveRole(Role role) {
        save(role);
    }

    public void saveUserRole(UserRole userRole) {
        save(userRole);
    }

    public void savePermission(Permission permission) {
        save(permission);
    }
}