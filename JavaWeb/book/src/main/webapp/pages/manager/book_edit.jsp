<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>

	<%-- 静态包含 base标签，css样式，jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}

    #img{
        font-size: 2px;
        width: 2px;
        margin-left: 10px;
    }
</style>
</head>
<body>

<%--		告诉服务器修改还是增加方式二：
		可以通过判断当前请求参数中是否包含含有id对象，如果有说明是修改update操作。没有说明是添加add操作
		${ empty param.id ? "add" : "update" }

		告诉服务器修改还是增加方式三：
		可以判断，Request域中是否包含有修改的图书信息对象，如果没有说明是添加操作，有说明是修改操作
		${ empty requestScope.book ? "add" : "update" }
--%>

		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%-- 静态包含 manager管理模块的菜单 --%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get" enctype="multipart/form-data">

				<input type="hidden" name="pageNo" value="${ param.pageNo }">
<%--				添加隐藏域action，告诉服务器修改还是增加 方式一，book_manager跳转到此，param.method:告诉服务器调用 什么 方法--%>
				<input type="hidden" name="action" value="${ param.method }"/>
				<input type="hidden" name="id" value="${ requestScope.book.id }"/>


<%--				告诉服务器修改还是增加 方式二：<input type="hidden" name="id" value="${ empty param.id ? "add" : "update" }"/>--%>
                <table>
                    <tr>
                        <td>名称</td>
                        <td>价格</td>
                        <td>作者</td>
                        <td>销量</td>
                        <td>库存</td>
<%--                        <td>封面</td>--%>
                        <td colspan="2">操作</td>
                    </tr>
                    <tr>
                        <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                        <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                        <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                        <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                        <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                        <td>
<%--                            <div id="img">--%>
<%--                                <input name="imgPath" type="file" value="${requestScope.book.imgPath}"/>--%>
<%--                            </div>--%>
                        </td>
                        <td><input type="submit" value="提交"/></td>
                    </tr>
                </table>
			</form>
			
	
		</div>

		<%--静态包含--%>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>