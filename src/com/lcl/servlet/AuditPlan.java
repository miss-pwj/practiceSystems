package com.lcl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

@WebServlet("/AuditPlan")
public class AuditPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String no = request.getParameter("no");
		String user =(String) request.getSession().getAttribute("user");
		
		if(!"admin".equals(user)){
			System.out.println("无审核权限");
			response.sendRedirect("showPlanNo.jsp");
			return;
		}
		
		Date date = new Date();
		
		Project project = new Project(no,date);
		ProjectService ps = new ProjectServiceImpl();
		//存入数据库
		if(ps.auditDateByNo(project)){
			request.getRequestDispatcher("GetPlanNo").forward(request, response);
			return;
		}else{
			String errorMessage = "审核失败,或服务器异常,请检查输入是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
