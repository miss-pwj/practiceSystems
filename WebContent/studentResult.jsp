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

	<c:if test="${empty requestScope.choose&&!empty requestScope.plan }">
		请不要着急，暂时还没有公司选择你<br>
	</c:if>
	<c:choose>
		<c:when test="${empty requestScope.plan }">
			你还未选择方案，快去选择吧。<br>
		</c:when>
		<c:otherwise>
		<table>
		<tr>
			<th>你选择的方案</th>
		</tr>
				<c:forEach var="plan" items="${requestScope.plan }">
					<tr> 
						<td>${plan }<input type="button" value="退选" onclick="window.location.href = 'StudentGiveUp?proNo=${plan}'"></td>
						<td>
							<c:if test="${plan==requestScope.choose }">你已被该方案所在公司选择选择</c:if>
						</td>
					</tr>
				</c:forEach>

			</table>
		
		</c:otherwise>
	</c:choose>
	<input type="button" value="返回" onclick="window.location.href='main.jsp'">
	
	
</body>
</html>