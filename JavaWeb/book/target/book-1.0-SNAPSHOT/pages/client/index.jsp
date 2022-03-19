<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

	<%-- 静态包含 base标签，css样式，jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){//页面加载完成之后
			$("button.addToCart").click(function (){
				//给加入购物车按钮绑定单击事件
				/**
				 * 在事件响应的function函数中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
				 * @type {*|jQuery}
				 */
				var bookId = $(this).attr("bookId");
				//跳转到指定路径，并传输数据，用Ajax局部更新数据，不用location整体传输数据
				// location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;

				//发Ajax请求，添加商品到购物车
				$.getJSON("http://localhost:8080/book/cartServlet","action=ajaxAddItem&id=" + bookId,function (data){
					$("#cartTotalCount").text("你的购物车有" + data.totalCount + "件商品");
					$("#cartLastName").text( data.lastName );
				})
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
<%--			用户还未登录，显示 【登录  注册】菜单--%>
				<c:if test="${ empty sessionScope.user }">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
<%--			用户已登录，显示登录成功后的用户信息--%>
				<c:if test="${ not empty sessionScope.user }">
					<span>欢迎<span class="um_span">${ sessionScope.user.username }</span>光临尚硅谷书城</span>
					<a href="orderServlet?action=queryMyIDOrder">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${ param.min }"> 元 -
						<input id="max" type="text" name="max" value="${ param.max }"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
					<c:if test="${ empty sessionScope.cart.itemList }">
						<span id="cartTotalCount"> </span>
						<div>
							<span style="color: red" id="cartLastName"> 当前购物车为空 </span>
						</div>
					</c:if>
					<c:if test="${not empty sessionScope.cart.itemList }">
						<span id="cartTotalCount">您的购物车中有 <span style="color: red">
								${ sessionScope.cart.totalCount } </span>件商品</span>
						<div>
							图书<span style="color: red" id="cartLastName"> ${ sessionScope.lastName } </span>添加至购物车
						</div>
					</c:if>
			</div>

			<c:forEach items="${ requestScope.page.items }" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${ book.imgPath }" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${ book.name }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${ book.author}</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">${ book.price }</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${ book.sales }</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${ book.stock }</span>
					</div>
					<div class="book_add">
						<button bookId="${ book.id }" class="addToCart">加入购物车</button>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>

<%--	静态包含分页条	--%>
		<%@include file="/pages/common/page_nav.jsp"%>
	
	</div>

	<%--静态包含--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>