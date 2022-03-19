<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/12/14
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" errorPage="error500.jsp" language="java" %>
<%@ page import="java.util.Map" %>
<!--
errorPage表示错误后自动跳转去的路径　<br/>
这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port/工程路径/
映射到代码的Web目录
-->

<html>
<head>
    <title>Title</title>
</head>
<body>
b.jsp页面
<!-- 这是html注释  -->
<%
    // 单行java注释
    /*  多行java注释  */
%>

<%-- 这是jsp注释  --%>

<%
    // int i = 12/0;
%>

</body>
</html>
