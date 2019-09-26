package com.lcl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project_select;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class ChooseStudent
 */
@WebServlet("/ChooseStudent")
public class ChooseStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String stuNo=request.getParameter("stuNo");
		String proNo = request.getParameter("proNo");
		Date date=new Date();
		String companyName = (String)request.getSession().getAttribute("uname");
		Project_select ps = new Project_select(stuNo,proNo,date,companyName);
		ProjectService proSer = new ProjectServiceImpl();
		int currentPage =(int) request.getSession().getAttribute("currentPage");
		//判断该学生是否已经被选了
		if(proSer.IsStudentChoose(stuNo, proNo)){
			request.setAttribute("choose", stuNo+"该学生已经被选择了！");
			request.getRequestDispatcher("CompanyChoose?currentPage="+currentPage).forward(request, response);
		}
		
		
		if(proSer.chooseStudentByNo(ps)){
			request.setAttribute("sign", "已选");
			request.setAttribute("choose", "成功选择！");
			request.getRequestDispatcher("CompanyChoose?currentPage="+currentPage).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
