<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/12/19
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("key","W");
%>
表达式脚本输出Key：<%=request.getAttribute("key")%><br>
EL表达式输出Key：${key}

</body>
</html>
