
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
<%--    manager/bookServlet：请求资源的地址，
        action=list：表示使用反射调用服务器功能里的哪一个方法，调用BookServlet下的list方法，查询所有图书并显示
                                                            调用BookServlet下的page方法，查询分页要显示的图书--%>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
