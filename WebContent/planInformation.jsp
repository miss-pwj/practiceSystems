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
		<c:choose>
			<c:when test="${sessionScope.user=='admin' }">
				<input type="button" onclick="window.history.back(-1)" value="返回">
			</c:when>
			<c:when test="${sessionScope.user=='student' }">
					<input type="button" onclick="window.history.back(-1)" value="返回">
			</c:when>
			<c:when test="${sessionScope.user=='company' }">
				<input type="button" onclick="window.history.back(-1)" value="返回">
			<%-- 	<c:choose>
					<c:when test="${sessionScope.may=='company' }">
					${sessionScope.may }
					<a href="CompanyChoose">返回</a>
					
					${sessionScope.may }
					</c:when>
					<c:otherwise>
					<a href="GetPlanNo">返回</a>
					</c:otherwise>
				</c:choose> --%>
			</c:when>
			<c:otherwise>
				游客，请登录
			</c:otherwise>
		</c:choose>
		<table border="1px" >
			<tr >
				<td width="70px" align="center">方案号</td>
				<td>${requestScope.project.no}</td>
			</tr>
			<tr>
				<td>方案名称</td>
				<td>${requestScope.project.name}</td>
			</tr>
			<tr>
				<td>方案简介</td>
				<td>${requestScope.project.introduction}</td>
			</tr>
			<tr>
				<td>学生人数</td>
				<td>${requestScope.project.studentsNum}</td>
			</tr>
			<tr>
				<td>企业用户名</td>
				<td>${requestScope.project.companyUsername}</td>
			</tr>
			<tr>
				<td>校外指导老师</td>
				<td>${requestScope.project.companyTeacher}</td>
			</tr>
			<tr>
				<td>校外指导老师职称</td>
				<td>${requestScope.project.companyTeacherTitle}</td>
			</tr>
			<tr>
				<td>发布日期</td>
				<td>${requestScope.project.releaseDate}</td>
			</tr>
			<tr>
				<td>年级</td>
				<td>${requestScope.project.grade}</td>
			</tr>
			<tr>
				<td>类别</td>
				<td>${requestScope.project.category}</td>
			</tr>
			<tr>
				<td>适用专业</td>
				<td>${requestScope.project.major}</td>
			</tr>
		</table>
</body>
</html>