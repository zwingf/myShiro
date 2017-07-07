package shiroweb5;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wing on 2017/7/7.
 */
public class Login extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String error = null;
        try {
            subject.login(token);
            System.out.println("用户登录成功");
        } catch (UnknownAccountException e) {
            error = "用户不存在";
        } catch (IncorrectCredentialsException e) {
            error = "密码错误";
        }
        if (error != null) {
            request.setAttribute("login.msg",error);
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/success.html");
    }
}
