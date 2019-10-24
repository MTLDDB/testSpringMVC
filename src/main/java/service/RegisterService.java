package service;

import model.Permission;
import model.Role;
import model.User;
import model.UserRole;

public interface RegisterService {
    //save user
    void saveUser(User user);

    //save role
    void saveRole(Role role);

    //save UserRole
    void saveUserRole(UserRole userRole);

    //save Permission
    void savePermission(Permission permission);
}
