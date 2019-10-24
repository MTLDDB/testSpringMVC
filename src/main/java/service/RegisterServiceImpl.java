package service;

import dao.BaseDao;
import dao.BaseDaoIml;
import model.Permission;
import model.Role;
import model.User;
import model.UserRole;

public class RegisterServiceImpl implements RegisterService {
    private BaseDao dao;

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public void saveRole(Role role) {
        dao.saveRole(role);
    }

    public void saveUserRole(UserRole userRole) {
        dao.saveUserRole(userRole);
    }

    public void savePermission(Permission permission) {
        dao.savePermission(permission);
    }

    public void setDao(BaseDaoIml dao) {
        this.dao = dao;
    }
}
