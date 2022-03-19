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
        <%
            System.out.println("a.jsp页面执行了吗？");
            Object user = session.getAttribute("user");
            //如果等于null，说明还没有登录
            if(user == null){
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        %>
我是a.jsp
</body>
</html>
