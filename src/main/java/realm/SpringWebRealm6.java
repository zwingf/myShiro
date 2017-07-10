package realm;

import biz.UserBiz;
import entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by wing on 2017/7/10.
 */
public class SpringWebRealm6 extends AuthorizingRealm {
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        String password = String.valueOf(token1.getPassword());
        UserBiz userBiz = new UserBiz();
        User user = userBiz.getUser(username, password);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
