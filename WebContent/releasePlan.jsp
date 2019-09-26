<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ReleasePlan">
		方案号：<input type="text" name="no"><br>
		方案名称：<input type="text" name="name"><br>
		方案简介：<input type="text" name="introduction"><br>
		学生人数：<input type="text" name="students_num"><br>
		企业用户名：<input type="text" name="company_username"><br>
		校外指导老师：<input type="text" name="company_teacher"><br>
		校外指导老师职称：<input type="text" name="company_teacher_title"><br>
		<!-- 发布日期：<input type="text" name="release_date">
		审核日期：<input type="text" name="audit_date">
		结束日期：<input type="text" name="end_date"> 
		方案总结：<input type="text" name="summary">-->
		年级：
		<select name="grade">
		  <option value ="2015">2015级</option>
		  <option value ="2016">2016级</option>
		  <option value ="2017">2017级</option>
		  <option value ="2018">2018级</option>
		</select><br>
		类别：
		<select name="category">
		  <option value ="综合实训">综合实训</option>
		  <option value ="技能实训">技能实训</option>
		  <option value ="综合实训">综合实训</option>
		</select><br>
		适用专业：
		<select name="major">
		 <option value ="软件工程">软件工程</option>
		  <option value ="电子信息工程(本)">电子信息工程</option>
		  <option value ="网络工程">网络工程</option>
		  <option value ="自动化">自动化</option>
		  <option value ="数字媒体技术">数字媒体技术</option>
		  <option value ="通信工程">通信工程</option>
		  <option value ="电气工程及其自动化(本)">电气工程及其自动化(本)</option>
		  <option value ="信息与计算科学">信息与计算科学</option>
		  <option value ="物联网工程">物联网工程</option>
		  <option value ="计算机科学与技术">计算机科学与技术</option>
		</select><br>
		<input type="submit" value="提交">
		<input type="button" value="返回" onclick="history.back(-1)">
	</form>
</body>
</html>