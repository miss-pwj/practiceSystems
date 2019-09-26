<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
当前用户：${sessionScope.uname}<br>
<a href="main.jsp">返回main.jsp</a><br>
${requestScope.choose }<br>
	    <table border="1px">
	    	<tr>
	    			<th>学号</th>
	    			<th>方案号</th>
	    			<th>选择理由</th>
	    			<th width="70px">学生信息</th>
	    			<th width="70px">方案信息</th>
	    			<th width="100px">操作</th>
	    	</tr>
	    <c:forEach var="list" items="${requestScope.list }">
	    	<tr>
	    		<td>${list.studentNo }</td>
	    		<td>${list.projectNo }</td>
	    		<td>${list.selReason }</td>
	    		<td><a href="StudentInformation?stuNo=${list.studentNo }">学生信息</a></td>
	    		<td><a href="PlanInformation?proNo=${list.projectNo}">方案信息</a></td>
	    		<td>
	    			<c:choose>
	    				<c:when test="${empty list.companySelDate }">
	    					<a href="ChooseStudent?stuNo=${list.studentNo}&proNo=${list.projectNo}">选择</a>
	    				</c:when>
	    				<c:otherwise>
	    					<input type="button" value="已选" readonly="readonly">
	    					<a href="CompanyGiveUp?stuNo=${list.studentNo}&proNo=${list.projectNo}">放弃</a>
	    				</c:otherwise>
	    			</c:choose>
	    			<c:remove var="sign" scope="request"/>
	    		</td>
	    	</tr>
	    </c:forEach>       
	    	
	    </table>
	    		<c:set  target="${requestScope.p }" property="pageSize" value="5"></c:set>
	    		<c:set 	var="currentPage" value="${p.currentPage }" scope="session"></c:set>
	    		当前页：${requestScope.p.currentPage },
	    		总页数：${requestScope.p.totalPage }<br>
		    		<c:if test="${requestScope.p.hasFirst}" var="res">
		    			<a href="CompanyChoose?currentPage=1&pageSize=${requestScope.p.pageSize }">首页</a>
		    		</c:if>
		    		<c:if test="${requestScope.p.hasPre }">
		    			<a href="CompanyChoose?currentPage=${requestScope.p.currentPage-1 }&pageSize=${requestScope.p.pageSize }">上一页</a>
		    		</c:if>
	    		<c:if test="${requestScope.p.hasNext }">
	    		<a href="CompanyChoose?currentPage=${requestScope.p.currentPage+1 }&pageSize=${requestScope.p.pageSize }">下一页</a>
	    		</c:if>
	    		<c:if test="${requestScope.p.hasLast }">
	    		<a href="CompanyChoose?currentPage=${requestScope.p.totalPage }&pageSize=${requestScope.p.pageSize }">尾页</a>
	    		</c:if>
		
</body>
</html>