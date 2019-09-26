package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Company;
import com.lcl.entity.Student;
import com.lcl.service.CompanyService;
import com.lcl.service.StudentService;
import com.lcl.service.impl.CompanyServiceImpl;
import com.lcl.service.impl.StudentServiceImpl;

@WebServlet("/IsPwdTrue")
public class IsPwdTrue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uname=request.getParameter("uname");
		String oldPwd = request.getParameter("oldPwd");
		System.out.println("进入修改密码"+uname+","+oldPwd);
		Student student = new Student(uname,oldPwd);
		Company company = new Company(uname,oldPwd);
		StudentService ss = new StudentServiceImpl();
		CompanyService cs = new CompanyServiceImpl();
		String user = (String)request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		if("student".equals(user)){
			if(ss.studentLogin(student)){
				out.write(" {\"exist\":\"true\"} ");
				return;
			}else{
				out.write(" {\"exist\":\"false\"} ");
				return;
			}
		}else if("company".equals(user)){
			if(cs.companyLogin(company)){
				out.write(" {\"exist\":\"true\"} ");
				return;
			}else{
				out.write(" {\"exist\":\"false\"} ");
				return;
			}
		}
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
