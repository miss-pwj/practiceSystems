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
	 function audit(){
		var $no=$("no").val();
		$.getJSON(
				"AuditPlan",		//请求路径
				{"no":$no},	//传递参数
		function(result){	
					//成功返回结果
					if(result.msg!="true"){
						alert("该方案已审核");
					}else{
						
					}
				}
		);
		
	}
	 </script>
</head>
<body>
<input type="button" value="返回" onclick="window.history.back(-1); ">
	<form action="PlanInfoServlet">
		<select name="way">
			<option value="0">全部方案</option>
			<option value="1">已审核方案</option>
			<option value="2">未审核方案</option>
		</select> <input type="submit" value="提交">
	</form>
	<table border="1px">
		<tr>
			<th>方案号</th>
			<th>状态</th>
			<th>详情</th>
			<c:if test="${sessionScope.user=='admin'&&requestScope.way==2}">
				<th>操作</th>
			</c:if>
		</tr>
		<c:choose>
			<c:when test="${requestScope.way==0 }">
				<c:forEach var="list" items="${requestScope.list }">
					<tr>
						<td>${list.no }</td>
						<c:choose>
							<c:when test="${empty list.auditDate }">
								<td>未审核</td>
							</c:when>
							<c:otherwise>
								<td>已审核</td>
							</c:otherwise>
						</c:choose>
						<td><a href="PlanInformation?proNo=${list.no }">详细信息</a></td>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.way==1 }">
				<c:forEach var="list" items="${requestScope.list }">

					<c:if test="${!empty list.auditDate }">
						<tr>
							<td>${list.no }</td>
							<td>已审核</td>
							<td><a href="PlanInformation?proNo=${list.no }">详细信息</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:when>
			<c:when test="${requestScope.way==2 }">
				<c:forEach var="list" items="${requestScope.list }">

					<c:if test="${empty list.auditDate }">
						<tr>
							<td>${list.no }</td>
							<td>未审核</td>
							<td><a href="PlanInformation?proNo=${list.no }">详细信息</a></td>
							<c:if test="${sessionScope.user=='admin'}">
								<td><input type="text" value="审核"
									onclick="window.location.href='AuditPlan?no=${list.no}'">
								</td>
							</c:if>
						</tr>
					</c:if>

				</c:forEach>
			</c:when>
			<c:otherwise>
				出错了
			</c:otherwise>

		</c:choose>


		<%-- <c:choose>
					<c:when test="${empty requestScope.bool}">
					<td><a href="AuditPlan?no=${list.no }" onclick="audit()">审核</a>
						审核<input type="text" value="${list.no }" id="no" onclick="audit()">
					</td>
					</c:when>
					<c:otherwise>
					<td>已过审</td>
					</c:otherwise>
				</c:choose> --%>



	</table>
	
</body>
</html>