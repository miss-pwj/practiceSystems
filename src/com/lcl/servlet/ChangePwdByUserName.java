package com.lcl.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class ChangePwdByUserName
 */
@WebServlet("/ChangePwdByUserName")
public class ChangePwdByUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String user = (String) request.getSession().getAttribute("user");
		String pwd =  request.getParameter("fpwd");
		String uname =  (String) request.getSession().getAttribute("uname");
		Student student = new Student(uname,pwd);
		Company company = new Company(uname,pwd);
		StudentService ss  = new StudentServiceImpl();
		CompanyService cs = new CompanyServiceImpl();
		if("student".equals(user)){
			if(ss.updatePwd(student)){
				System.out.println("修改密码成功");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				System.out.println("失败");
			}
		}else if("company".equals(user)){
			if(cs.updatePwd(company)){
				System.out.println("修改密码成功");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				System.out.println("失败");
			}
		}else{
			System.out.println("管理员请直接操作数据库修改密码");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
