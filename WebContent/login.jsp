<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <script type="text/javascript">
      //刷新验证码
      function changeImg(){
          document.getElementById("validateCodeImg").src="ValidateServlet?"+Math.random();
    }
    </script>
    
</head>
<body>
	<h4>${requestScope.message }</h4>
	<form action="LoginServlet">
	用户名：<input type="text" name="uname"><br>
	密码：<input type="text" name= "upwd"><br>
	验证码：<input type="text" name="uyzm"> <img alt="验证码看不清，换一张" src="ValidateServlet" id="validateCodeImg" onclick="changeImg()">
             <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
            <br/> 
     <input type="radio" name="user" value="student">学生
    <input type="radio" name="user" value="company">公司
    <input type="radio" name="user" value="admin">管理员<br>
	<input type="submit" value="登录">
	<input type="button" value="注册" onclick="window.location.href = 'company_reg.jsp';">
	</form>
	<br>
	
	<a href="forgetPWD.jsp">忘记密码</a><br>
</body>
</html>