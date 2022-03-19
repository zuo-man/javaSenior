<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单</title>

    <%-- 静态包含 base标签，css样式，jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
    <style>
        a {
            color: blue;
            margin-left: 1000px;
            margin-bottom: 100px;
            font-size: 20px;
        }
    </style>

</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif" >
    <span class="wel_word">订单详情</span>

</div>


<div id="main">

    <table>
        <tr>
            <td>书名</td>
            <td>数量</td>
            <td>单价</td>
            <td>总金额</td>
        </tr>
        <c:forEach items="${ requestScope.orderItems }" var="order">
            <tr>
                <td>${ order.name }</td>
                <td>${ order.count }</td>
                <td>${ order.price }</td>
                <td>${ order.totalPrice }</td>
            </tr>
        </c:forEach>
        <a href="javascript:history.back(-1)">返回</a>

    </table>




</div>

<%--静态包含--%>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>