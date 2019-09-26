package com.lcl.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.System_Parameter;
import com.lcl.service.AdminService;
import com.lcl.service.impl.AdminServiceImpl;
import com.lcl.util.DateUtils;

@WebServlet("/ProjectTime")
public class ProjectTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = (String) request.getSession().getAttribute("uname");
		Date releaseProjectStartDate = DateUtils.stringToDate(request.getParameter("releaseProjectStartDate"));
		Date releaseProjectEndDate =DateUtils.stringToDate(request.getParameter("releaseProjectEndDate"));
		Date studentSelStartDate = DateUtils.stringToDate("studentSelStartDate");
		Date studentSelEndDate = DateUtils.stringToDate(request.getParameter("studentSelEndDate"));
		System_Parameter sp = new System_Parameter(name,releaseProjectStartDate,releaseProjectEndDate,studentSelStartDate,studentSelEndDate);
		AdminService as = new AdminServiceImpl();
		if(as.setTimeStartEnd(sp)){
			System.out.println("设置成功");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			String errorMessage = "登录失败,或服务器异常,请检查输入是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
