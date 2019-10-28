package shiro;


import model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import service.AccountService;
import service.AccountServiceImpl;

import java.util.List;


/****
 * 自定义Realm
 */
public class MyShiroRealm extends AuthorizingRealm {
    /**用户的业务类**/
    @Autowired
    private AccountService accountService;
    /***
     * 获取授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        //根据自己系统规则的需要编写获取授权信息，这里为了快速入门只获取了用户对应角色的资源url信息
        String username = (String) pc.fromRealm(getName()).iterator().next();
        if (username != null) {
            List<String> pers = accountService.getPermissionsByUserName(username);
            if (pers != null && !pers.isEmpty()) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                for (String each : pers) {
                    //将权限资源添加到用户信息中
                    info.addStringPermission(each);
                }
                return info;
            }
        }
        return null;
    }
    /***
     * 获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) at;
        // 通过表单接收的用户名
        String username = token.getUsername();
        if (username != null && !"".equals(username)) {
            List<User> users = accountService.getUserByUserName(username);

            if (users != null&&users.size()!=0) {
                System.out.println(users.get(0).getName());
                return new SimpleAuthenticationInfo(users.get(0).getName(), users.get(0).getPassword(), getName());
            }
        }
        return null;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
}
