package demo1;

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
public class Test1 {
    @Test
    public void shirologin(){
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = managerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("用户登录成功");
        } catch (AuthenticationException e) {
            System.out.println(e);
            System.out.println(" 身份校验失败");
        }
        subject.logout();
    }
}
