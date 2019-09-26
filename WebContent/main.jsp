<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	
	 function back(){
		$.getJSON(
				"SessionInvalidate",		//请求路径
				{},	//传递参数
		function(result){	
					//成功返回结果
				alert("销毁")
				}
		);
		
	}
	 </script>
</head>
<body>	
	<img src="./img/photo.jpg" width="50px" height="50px">
		当前操作对象：${sessionScope.user}<br>
			
			<a href="resetPwd.jsp">修改密码</a><br>
		<!-- 	<a href="GetPlanNo">查看方案号</a><br> -->
		<c:choose>
			<c:when test="${sessionScope.user=='admin' }">
				<a href="GetPlanNo">查看方案号</a><br>
				<a href="AdminPlan">管理员查看方案</a><br>
				<a href="releasePlanDate.jsp">设置发布选择方案时间</a><br>
			</c:when>
			<c:when test="${sessionScope.user=='student' }">
				<a href="StudentPlan">学生查看方案</a><br>
				<!-- <a href="studentChooseProject.jsp">学生选择方案</a><br> -->
				<a href="StudentLookResult">查看结果</a><br>
			</c:when>
			<c:when test="${sessionScope.user=='company' }">
				<a href="GetPlanNo">查看方案号</a><br>
				<a href="releasePlan.jsp">企业发布方案</a><br>
				<a href="CompanyChoose">企业选择学生</a><br>
			</c:when>
			<c:otherwise>
				当前用户：${sessionScope.user}<br>
			</c:otherwise>
		</c:choose>
		<a href="login.jsp" onclick="back()">退出登录</a>
		
</body>
</html>