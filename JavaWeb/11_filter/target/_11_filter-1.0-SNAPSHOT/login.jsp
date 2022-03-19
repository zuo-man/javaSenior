<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2022/1/8
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

登录<br>

    <form action="http://localhost:8080/11_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/> <br>
        密码：<input type="password" name="password"/> <br>
        <input type="submit" />
    </form>

</body>
</html>
