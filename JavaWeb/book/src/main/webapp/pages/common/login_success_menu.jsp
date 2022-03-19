
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span class="wel_word"></span>
<div>
    <span>欢迎<span class="um_span">${ sessionScope.user.username }</span>光临尚硅谷书城</span>
    <a href="orderServlet?action=queryMyIDOrder">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
