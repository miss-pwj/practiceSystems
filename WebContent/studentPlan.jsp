<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deChoose(){
		var $desel=$("#desel").val();
		
		$.getJSON(
				StudentGiveUp,		//请求路径
				{"mobile=":$mobile},	//传递参数
		function(result){				//成功返回结果
					if(result.msg=="true"){
						alert("已经存在！注册失败");
					}else{
						alert("注册成功");
					}
				}
		);
		
	}

</script>
</head>
<body>
	<h1>学生查看方案</h1>
	   <%--  <table border="1px">
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
                <th>结束日期</th>
                <th>年级</th>
                <th>类别</th>
                <th>适用专业</th>
        </tr>
	<c:forEach var="list" items="${requestScope.list }">
		<tr>
			<td>${list.No}</td>
			<td>${list.name}</td>
			<td>${list.introduction}</td>
			<td>${list.studentsNum}</td>
			<td>${list.companyUsername}</td>
			<td>${list.companyTeacher}</td>
			<td>${list.companyTeacherTitle}</td>
			<td>${list.releaseDate}</td>
			<td>${list.auditDate}</td>
			<td>${list.endDate}</td>
			<td>${list.summary}</td>
			<td>${list.grade}</td>
			<td>${list.category}</td>
			<td>${list.major}</td>
		</tr>
	</c:forEach>        
    </table>
    
    	<form action="main.jsp">
	    		<input type="submit" value="返回">
	    	</form> --%>
	    	
	    ${requestScope.err }<br>
	    <table border="1px">
	    	<tr>
	    			<th>方案号</th>
	    			<th>方案名称</th>
	    			<th>详细信息</th>
	    			<th>操作</th>
	    	</tr>
	    <c:forEach var="list" items="${requestScope.list }">
	    	<c:if test="${!empty list.auditDate }">
	    	<tr>
	    		<td>${list.no }</td>
	    		<td>${list.name }</td>
	    		<td><a href="PlanInformation?proNo=${list.no}">详细信息</a></td>
	    		<td>
	    			<c:choose>
	    				<c:when test="${empty requestScope.sign }">
	    					<a href="studentChooseProject.jsp?proNo=${list.no}">选择</a>
	    				</c:when>
	    				<c:otherwise>
	    					<input type="button" value="${requestScope.sign }" readonly="readonly">
	    					<a href="StudentGiveUp?proNo=${list.no}">放弃</a>
	    				</c:otherwise>
	    			</c:choose>
	    			
<!-- 	    		<input type="button" value="放弃选择" name="desel" id="desel" onclick="deChoose()">
 -->	    		</td>
	    	</tr>
	    	</c:if>
	    </c:forEach>       
	    </table>
		<a href="main.jsp">返回main.jsp</a>
	    
</body>
</html>