package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

@WebServlet("/PlanInformation")
public class PlanInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String no = request.getParameter("proNo");
		//System.out.println(no);
		ProjectService ps = new ProjectServiceImpl();
		Project project = ps.querryPlanByNo(no);
	//	System.out.println("方案信息："+project.getNo()+","+project.getName());
		request.setAttribute("project", project);
		request.getRequestDispatcher("planInformation.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
