<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--每个书城页面需要有base标签，每个页面需要引入css样式，每个页面用的javascript都是jquery，然后用静态包含给每个页面-->

<!-- 需要动态获取服务器地址值  getScheme:协议名http、 getServerName：服务器IP、 getServerPort：端口号、 getContextPath：工程路径-->
<%
    String basePath = request.getScheme()
        + "://"
        + request.getServerName()
        + ":"
        + request.getServerPort()
        + request.getContextPath()
        + "/";

    pageContext.setAttribute("basePath", basePath);
%>
<!--写base标签，永远固定相对路径跳转的结果-->
<!-- 添加了base标签，原来的路径得改，否则网页会按base标签开始-->
<base href="<%=basePath%>>">


<!--<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >-->

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

