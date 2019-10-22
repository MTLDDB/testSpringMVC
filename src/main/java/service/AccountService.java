package service;
import model.User;
import org.springframework.stereotype.Service;
import java.util.List;

public interface AccountService {


    /****
     * 通过用户名获取用户对象
     *
     * @param username
     * @return
     */
    public List<User> getUserByUserName(String username);



    /***
     * 通过用户名获取权限资源
     *
     * @param username
     * @return
     */
    public List<String> getPermissionsByUserName(String username) ;


}
