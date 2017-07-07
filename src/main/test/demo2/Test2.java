package demo2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by wing on 2017/7/7.
 */
public class Test2 {
    @Test
    public void shiroLogin(){
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro2.ini");
        SecurityManager securityManager = managerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("tom", "123");
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}
