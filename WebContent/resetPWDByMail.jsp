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


/* function select(){
	var $umail=$("#umail").val();
	$.getJSON(
			"IsMailExist",		//请求路径
			{"umail":$umail},	//传递参数
	function(result){	
				//成功返回结果
				if(result.msg!="true"){
					alert("该邮箱不存在，请验证你的邮箱");
				}
			}
	);
	
}
	function IsCodeTrue(){
		var $uyzm=$("#uyzm").val();
		
		$.getJSON(
				"IsCodeTrue",		//请求路径
				{"uyzm":$uyzm},	//传递参数
		function(result){				//成功返回结果
					if(result.msg!="true"){
						alert("验证码错误");
					}
				}
		);
		
	} */

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
	<form action="ChangePWDByMail">
		密保邮箱：<input type="text" name="umail" id="umail" readonly="readonly" value="${requestScope.mail }"><br>
		验证码：<input type="text" name="uyzm" id="uyzm" readonly="readonly" value="${requestScope.yzm }"><br>
		请输入密码：<input type="password" name="fpwd" id="fpwd"><br>
		再次输入密码：<input type="password" name="spwd" id="spwd" onblur="checkPwd()"><br>
		<input type="submit" value="提交" >
	</form>
	
</body>
</html>