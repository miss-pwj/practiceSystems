<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib uri="http://lcl/tag" prefix="lcl"%>
<%@  taglib uri="http://lcl/function" prefix="func"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" onclick="window.history.back(-1)" value="返回">
	<table border="1px" style="font-size: 10px">
		<tr>
			<th>方案号</th>
			<th>方案名称</th>
			<th>方案简介</th>
			<th>学生人数</th>
			<th>企业用户名</th>
			<th>校外指导老师</th>
			<th>校外指导老师职称</th>
			<th>发布日期</th>
			<th>审核日期</th>
			<th>年级</th>
			<th>类别</th>
			<th width="300px">适用专业</th>
		</tr>
		<c:forEach var="list" items="${requestScope.list }">
			<tr>
				<td>${list.no}</td>
				<td>${list.name}</td>
				<td>
					<div title="${list.introduction}">
						<p>
							<lcl:if test="${func:strLength(list.introduction) >20}">
				${func:subString(list.introduction)}
			</lcl:if>
							<lcl:if test="${func:strLength(list.introduction) <=20}">
				${list.introduction}
			</lcl:if>
						</p>
					</div>
				</td>
				<td>${list.studentsNum}</td>
				<td>${list.companyUsername}</td>
				<td>${list.companyTeacher}</td>
				<td>${list.companyTeacherTitle}</td>
				<td>${list.releaseDate}</td>
				<td>${list.auditDate}</td>
				<td>${list.grade}</td>
				<td>${list.category}</td>
				<td>
				<div title="${list.major}">
				<p><lcl:if test="${func:strLength(list.major) >10}">
				${func:subString(list.major)}
				</lcl:if> 
				<lcl:if test="${func:strLength(list.major) <=10}">
				${list.major}</lcl:if>
				</p>
				</div>
				
			</td>
			</tr>
		</c:forEach>
	</table>

	<%--  <c:choose >
    	<c:when test="${session.user =='admin' }">
	    	审核方案
	    	<input type="button" value="返回" onclick="window.location.href='main.jsp'">
	    	</c:when>
    	<c:otherwise>
	    		
    	</c:otherwise>
    </c:choose> --%>

</body>
</html>