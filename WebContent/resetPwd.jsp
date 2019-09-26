<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	
	 function register(){
		var $oldPwd=$("#oldPwd").val();
		var $uname=$("#uname").val();
		$.getJSON(
				"IsPwdTrue",		//请求路径
				{"uname":$uname,"oldPwd":$oldPwd},	//传递参数
		function(result){	
					//成功返回结果
					if(result.exist=="false"){
						alert("密码输入错误，请重新输入");
					}
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
		当前用户：${sessionScope.uname }<br>
		<form action="ChangePwdByUserName">
					<input type="hidden" id="uname" value="${sessionScope.uname }" name="uname" >
		请输入旧密码：<input type="password" name="oldPwd" id="oldPwd"><br>
		请输入新密码：<input type="password" name="fpwd" id="fpwd" onclick="register()"><br>
		请重新输入新密码：<input type="password" name="spwd" id="spwd" onblur="checkPwd()"><!-- onblur当元素失去焦点时 -->
					<!-- <input type="button" value="查看" onclick="checkPwd()"><br> -->
					<br><input type="submit" value="修改" >
					<input type="button" value="返回" onclick="javascript :history.back(-1);">
		</form>
		
</body>
</html>