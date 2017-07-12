<%--
  Created by IntelliJ IDEA.
  User: wing
  Date: 2017/7/7
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    ${requestScope["login.msg"]}
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username" placeholder="用户名"><br/>
        密码：<input type="password" name="password" ><br/>
        <input type="submit" value="登录" >
    </form>
</body>
</html>
