<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/12/25
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%--	分页条的开始--%>
<div id="page_nav">
    <%--			大于首页，前面才显示上一页--%>
    <c:if test="${ requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo-1 }">上一页</a>
    </c:if>

<%--		页码输出的开始--%>
    <c:choose>
<%--		情况一：总页码小于等于5的情况，页码的范围是：1-总页码	--%>
        <c:when test="${ requestScope.page.pageTotal <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${ requestScope.page.pageTotal }"/>
        </c:when>
<%--		情况二：总页码大于5的情况，分三个小情况	--%>
        <c:when test="${ requestScope.page.pageTotal > 5 }">
            <c:choose>
                <c:when test="${ requestScope.page.pageNo <= 3}">
<%--				小情况 1 ：当前页码为前面3个：1，2，3的情况，页码范围是1-5--%>
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
<%--				小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4 - 总页码--%>
                <c:when test="${ requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${ requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${ requestScope.page.pageTotal }"/>
                </c:when>
<%--				小情况3：   4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${ requestScope.page.pageNo - 2 }"/>
                    <c:set var="end" value="${ requestScope.page.pageNo + 2 }"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

<%--	优化，将上方的begin，end 方法集合到一处      --%>
    <c:forEach begin="${ begin }" end="${ end }" var="i">
        <c:if test="${ i == requestScope.page.pageNo }">
            [ ${ i } ]
        </c:if>
        <c:if test="${ i != requestScope.page.pageNo }">
            <a href="${ requestScope.page.url }&pageNo=${ i }">
                    ${ i }
            </a>
        </c:if>
    </c:forEach>
<%--		页码输出的结束--%>

<%--	末页时，下一页，末页不显示--%>
    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageTotal }">末页</a>
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo+1 }">下一页</a>
    </c:if>

    共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount}条记录
    到第<input value="${ param.pageNo }" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        //页面加载完成之后
        $(function (){
            //跳到指定的页码
            $("#searchPageBtn").click(function (){
                var pageNo = $("#pn_input").val();
                //获取总页码
                var pageTotal = ${ requestScope.page.pageTotal };
                if (  pageNo < 1 || pageTotal < pageNo){
                    alert("非法跳转");
                } else {
                    /*
                    javaScript语言中提供了一个Location地址栏对象，它有一个属性叫href，可以获取浏览器中的地址
                    href属性，可读可写、  basePath：工程路径
                     */
                    location.href = "${ pageScope.basePath }${ requestScope.page.url }&pageNo=" + pageNo;
                }

            })
        })
    </script>
</div>
<%--	分页条的结束--%>
