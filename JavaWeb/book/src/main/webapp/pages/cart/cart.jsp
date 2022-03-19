<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%-- 静态包含 base标签，css样式，jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

			<!--静态包含，登录 成功之后的菜单-->
			<%@ include file="/pages/common/login_success_menu.jsp"%>
			<script type="text/javascript">
				$(function (){
					//给删除绑定单击事件
					$("a.deleteDetermine").click(function (){
						return confirm("确定删除【" + $(this).parent().parent().find("td:first").text() + "】？");
					});
					//给清空购物车绑定单击事件
					$("#clearDetermine").click(function (){
						return confirm("确定清空购物车？");
					});

					//blur：给输入框绑定失去焦点事件
					//change：内容发生改变事件
					$(".updateCount").change(function (){
						//获取商品名称
						var name = $(this).parent().parent().find("td:first").text();
						var id = $(this).attr('bookId');
						//获取商品数量
						var count = this.value;
						if( confirm("确定更新商品【" + name + "】数量为：" + count) ){
							//发起请求，给服务器保存修改
							location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+id;
						}else {
							//defaultValue属性是表单项Dom对象的属性，表示默认的value属性值
							//取消更新，数量返回原来的
							this.value = this.defaultValue;
						}
					});
				});
			</script>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${ not empty sessionScope.cart.itemList }">
				<%--购物车有商品情况（非空）--%>
				<c:forEach items="${ sessionScope.cart.itemList }" var="entry">
					<tr>
						<td>${ entry.value.name }</td>
						<td>
							<input class="updateCount" style="width: 25px;"
<%--								   可以通过如下自定义属性，记录下任何需要的信息--%>
								   bookId="${ entry.value.id }"
								   type="text" value="${ entry.value.count }">
						</td>
						<td>${ entry.value.price }</td>
						<td>${ entry.value.totalPrice }</td>
<%--					商品项有多个，用class绑定单机事件，而清空购物车只有一个按钮，用id绑定单机事件--%>
						<td><a class="deleteDetermine" href="cartServlet?action=deleteItem&id=${ entry.value.id }">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${ empty sessionScope.cart.itemList }">
				<%--购物车没有商品情况（空）--%>
				<tr>
<%--					colspan：跨行显示--%>
					<td colspan="5"><a href="index.jsp">当前购物车为空，点击跳转首页</a></td>
				</tr>
			</c:if>

<%--		forEach：遍历每个items商品    	entry：每个商品项--%>

		</table>

<%--		购物车非空才输出页面的内容--%>
		<c:if test="${ not empty sessionScope.cart.itemList }">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${ sessionScope.cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${ sessionScope.cart.totalPrice }</span>元</span>
				<span class="cart_span"><a id="clearDetermine" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	</div>

	<%--静态包含--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>