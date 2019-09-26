<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
      //刷新验证码
      function changeImg(){
          document.getElementById("validateCodeImg").src="ValidateServlet?"+Math.random();
    }
    </script> -->
    
 <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	 function sendMail(){
		 alert("asdfsa");
		var $cmail=$("#cmail").val();
		$.getJSON(
				"SendMailServlet",		//请求路径
				{"cmail":$cmail},	//传递参数
		function(result){	
					//成功返回结果
				}
		);
		
	}
	 
	 function checkPwd(){
			var $fpwd=$("#fpwd").val();
			var $spwd=$("#spwd").val();
			$.getJSON(
					"IsPwdSame",		//请求路径
					{"fpwd":$fpwd,"spwd":$spwd},	//传递参数
			function(result){	
						//成功返回结果
						if(result.exist=="null"){
							alert("请输入密码");
						}else{
							alert("两次输入密码不一致,请重新输入");
						}
					}
			);
	 }
</script>
</head>
<body>
	<h4>实训企业注册</h4>
	<h1>${requestScope.message}</h1>

	<form action="Company_Reg">
		<input type="text" placeholder="注册邀请码" name="icode"><br>
		<input type="text" placeholder="企业名称" name="cname"><br>
		<input type="text" placeholder="企业账号" name="uname"><br>
		<input type="password" placeholder="用户密码" name="cpwd" id="fpwd"><br>
		<input type="password" placeholder="请再次输入密码" name="cdpwd" id="spwd" onblur="checkPwd()"><br>
		<input type="text" placeholder="公司邮箱" name="cmail" id="cmail"><input type="button" value="发送验证码" onclick="sendMail()"><br>
		<input type="text" placeholder="验证码" name="cyzm"><br><!--  <img alt="验证码看不清，换一张"
			src="ValidateServlet" id="validateCodeImg" onclick="changeImg()">
		<a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a> <br /> -->
		<input type="submit" value="提交"><br> 已有账号？<input
			type="button" value="登录"
			onclick="window.location.href = 'login.jsp';">

	</form>

	<%-- <c:if test="${cpwd!=cdpwd }">
		<%
	 		String messge="两次密码不一致";
	 		request.setAttribute("message", messge);
	 		request.getRequestDispatcher("company_reg.jsp").forward(request, response);
	 	%>
	</c:if> --%>
</body>
</html>