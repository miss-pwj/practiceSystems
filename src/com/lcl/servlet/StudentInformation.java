package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project;
import com.lcl.entity.Student;
import com.lcl.service.StudentService;
import com.lcl.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentInformation
 */
@WebServlet("/StudentInformation")
public class StudentInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String stuNo = request.getParameter("stuNo");
		StudentService ss = new StudentServiceImpl();
		Student student = ss.querryStudentByNo(stuNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentInformation.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
