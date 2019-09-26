package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Company;
import com.lcl.entity.Student;
import com.lcl.service.CompanyService;
import com.lcl.service.StudentService;
import com.lcl.service.impl.CompanyServiceImpl;
import com.lcl.service.impl.StudentServiceImpl;
import com.lcl.util.MakeCode;

@WebServlet("/IsMailExist")
public class IsMailExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String mail=request.getParameter("umail");
		System.out.println(mail);
		StudentService ss = new StudentServiceImpl();
		Student student  =new Student(mail);
		System.out.println("进入ajax");
		CompanyService cs = new CompanyServiceImpl();
		Company company = new Company(mail);
		
		PrintWriter out =response.getWriter();
		String code=MakeCode.getCode();
		session.setAttribute("mail", mail);
		if(ss.isMailExist(student)){
			session.setAttribute("type", 2);
			session.setAttribute("code", code);
			out.write(" {\"msg\":\"true\"} ");
		}else if(cs.isMailExist(company)){
			out.write(" {\"msg\":\"true\"} ");
			session.setAttribute("code", code);
			session.setAttribute("type", 1);
		}
		else{
			out.write(" {\"msg\":\"false\"} ");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
