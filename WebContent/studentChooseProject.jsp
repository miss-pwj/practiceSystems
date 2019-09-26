<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="StudentChoose">
			选择方案：<input type="text" name="proNo" value="${param.proNo}" readonly="readonly"><br>
			选题理由：<input type="text" name="reason"><br>
		<!-- 	选择公司名称：<input type="text" name="company"><br> -->
			<input type="submit" value="提交">
		</form>
</body>
</html>