<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%-- 静态包含 base标签，css样式，jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


	<script type="text/javascript">
		// 加载页面之后
		$(function (){
			//给删除的a标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				// 在事件的function函数中，有一个this对象，此this对象是当前正在响应事件的dom对象
				/*
                confirm是确认提示框函数，参数是它的提示内容
                有两个按钮，一个确认，一个取消。 返回true表示点击，确认，返回false表示点击取消
                 */
				// 获取dom对象，获取父元素td，再在获取父元素tr，再在查找里面的第一个元素：图书名
				return confirm("确定要删除【" + $(this).parent().parent().find(" td:first ").text() +"】？");

				//return false //阻止元素的默认行为 ==> 不提交请求
			});
		});
	</script>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

			<%-- 静态包含 manager管理模块的菜单 --%>
			<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${ requestScope.page.items }" var="book">
				<tr>
					<td>${ book.name }</td>
					<td>${ book.price }</td>
					<td>${ book.author }</td>
					<td>${ book.sales }</td>
					<td>${ book.stock }</td>

<%--					method=update，跳转到book_edit，告诉服务器调用 update， 修改后，把当前页码发过去 --%>
					<td><a href="manager/bookServlet?action=getBook&id=${ book.id }&method=update&pageNo=${ requestScope.page.pageNo }">修改</a></td>

<%--					用户点击删除，添加a标签提示信息，class = deleteClass--%>
					<td><a class="deleteClass"
						   href="manager/bookServlet?action=delete&id=${ book.id }&pageNo=${ requestScope.page.pageNo }">删除</a></td>

				</tr>

			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

<%--				method=update，跳转到book_edit，告诉服务器调用add--%>
				<td><a href="pages/manager/book_edit.jsp?&method=add&pageNo=${ requestScope.page.pageTotal }">添加图书</a></td>
			</tr>	
		</table>


		<%--	静态包含分页条	--%>
		<%@include file="/pages/common/page_nav.jsp"%>

	</div>

	<%--静态包含--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>