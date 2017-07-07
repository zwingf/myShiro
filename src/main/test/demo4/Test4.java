package demo4;

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
public class Test4 {
    @Test
    public void shiroLogin(){
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro4.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            subject.login(token);
            System.out.println("登录成功");
//          获取用户相关的角色信息
            boolean roles = subject.hasRole("roles");
            if (roles)
                System.out.println("您拥有roles角色权限");
            else
                System.out.println("没有roles角色权限");
//          获取用户相关的权限信息
            boolean permittedAll = subject.isPermittedAll("admin:add", "admin:update");
            System.out.println("该用户是否拥有这权限："+permittedAll);
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码错误");
        }
    }
}
