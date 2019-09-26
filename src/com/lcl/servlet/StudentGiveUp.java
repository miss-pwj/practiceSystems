package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project_select;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class StudentGiveUp
 */
@WebServlet("/StudentGiveUp")
public class StudentGiveUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String projectNo = request.getParameter("proNo");
		String studentNO = (String)request.getSession().getAttribute("uname");
		Project_select ps = new Project_select(studentNO,projectNo);
		ProjectService proSel = new ProjectServiceImpl();
		if(!proSel.isStudentChoose(studentNO)){
			String errorMessage = "该学生并没有选择方案,请检查项目是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
		if(proSel.giveUpPlan(ps)){
			System.out.println("删除成功");
			request.getRequestDispatcher("StudentPlan").forward(request, response);
			return;
		}else{
			String errorMessage = "删除失败,或服务器异常,请检查项目是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
