<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="CompanyChoose">返回</a>
		<table>
			<tr>
				<td>学号</td>
				<td>${requestScope.student.no}</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>${requestScope.student.name}</td>
			</tr>
			<tr>
				<td>年级</td>
				<td>${requestScope.student.grade}</td>
			</tr>
			<tr>
				<td>专业名称</td>
				<td>${requestScope.student.professional}</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>${requestScope.student.gender}</td>
			</tr>
			<tr>
				<td>班级</td>
				<td>${requestScope.student.classNo}</td>
			</tr>
		</table>
</body>
</html>