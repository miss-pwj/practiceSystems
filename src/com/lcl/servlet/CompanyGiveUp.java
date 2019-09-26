package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

@WebServlet("/CompanyGiveUp")
public class CompanyGiveUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String stuNo=request.getParameter("stuNo");
		String proNo = request.getParameter("proNo");
		int currentPage = (int)request.getSession().getAttribute("currentPage");
		ProjectService ps = new ProjectServiceImpl();
		if(ps.companyGiveUp(stuNo, proNo)){
			request.getRequestDispatcher("CompanyChoose?currentPage="+currentPage).forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
