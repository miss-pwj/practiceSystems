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
	 /*function register(){
		var umail=document.getElementById("umail").value;
		//通过ajax异步方式请求服务端
		xmlHttpRequest =new XMLHttpRequest();
		
		//设置xmlHttpRequest对象的回调函数
		xmlHttpRequest.onreadystatechange=callBack;
		
		xmlHttpRequest.open("post","IsMailExist",true);
		//设置post方式的头信息
		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
		xmlHttpRequest.send("umail="+umail);  //k=v
		
		
		如果是get方式上传，xmlHttpRequest.send(null); 
		参数通open方法上传，xmlHttpRequest.open("get","MobileServlet?mobile="+mobile,true);
		
		
	}
	
	//定义回调函数（接受服务端的返回值）
	function callBack(){
		if(xmlHttpRequest.readyState ==4&&xmlHttpRequest.status ==200){
			//接受服务端返回的数据
			var data=xmlHttpRequest.responseText;  //服务端返回为String格式
			//alert(data.length+"==="+data)
			if(data=="true"){
				//alert("");
			}else{
				alert("该邮箱未存在!");
			}
		}
	}
	*/
</script>
</head>
<body>
		忘记密码，输入邮箱验证
		<form action="QuerryMail">
			邮箱：<input type="text" name="umail" id="umail">
			<input type="button" value="发送验证码" onclick="register()"><br>
			验证码：<input type="text"  name="uyzm"><br>
			<input type="submit" value="提交">
		</form>
</body>
</html>