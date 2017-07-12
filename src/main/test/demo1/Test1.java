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
//        通过IniSecurityManagerFactory加载ini配置文件
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        获取到SecurityManager安全管理器
        SecurityManager securityManager = managerFactory.getInstance();
//        shiro的主要封装工具类SecurityUtils，需要先绑定安全管理器
        SecurityUtils.setSecurityManager(securityManager);
//        用工具类获取一个subject，用户登录就是通过这个对象来实现的
        Subject subject = SecurityUtils.getSubject();
//        这里用需要的验证的用户名和密码封装一个验证token，注意这里的用户名跟密码是你需要验证的，不是ini配置文件中配置的
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123");
//        通过捕获异常的方式来建议用户验证是否成功
        try {
            subject.login(usernamePasswordToken);
            System.out.println("用户登录成功");
        } catch (AuthenticationException e) {
            System.out.println(e);
            System.out.println(" 身份校验失败");
        }
//        用于用户登出，如果配置有缓存，这里就会清空用户登录记录的信息。
        subject.logout();
    }
}
