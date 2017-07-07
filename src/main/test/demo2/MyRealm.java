package demo2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by wing on 2017/7/7.
 */
public class MyRealm implements Realm {
    public String getName() {
        return "myreaml1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        char[] chars = (char[])authenticationToken.getCredentials();
        String password = new String(chars);
        if (!"tom".equals(username))
            throw new UnknownAccountException("用户名错误");
        if (!"123".equals(password))
            throw new IncorrectCredentialsException("密码错误");
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
