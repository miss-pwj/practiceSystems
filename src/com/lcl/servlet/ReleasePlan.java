package com.lcl.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project;
import com.lcl.entity.System_Parameter;
import com.lcl.service.AdminService;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.AdminServiceImpl;
import com.lcl.service.impl.ProjectServiceImpl;
import com.lcl.util.DateUtils;

@WebServlet("/ReleasePlan")
public class ReleasePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String introduction = request.getParameter("introduction");
		int students_num = Integer.parseInt(request.getParameter("students_num"));
		String company_username = request.getParameter("company_username");
		String company_teacher = request.getParameter("company_teacher");
		String company_teacher_title = request.getParameter("company_teacher_title");
		/*Date release_date= DateUtils.splitStringToDate(request.getParameter("release_date"));
		Date audit_date= DateUtils.splitStringToDate(request.getParameter("audit_date"));
		Date end_date=DateUtils.splitStringToDate(request.getParameter("end_date"));*/
		AdminService as = new AdminServiceImpl();
		System_Parameter sp = as.querryDate("admin");
		Date date = new Date();
		if(!DateUtils.belongCalendar(date, sp.getReleaseProjectStartDate(), sp.getReleaseProjectEndDate())){
			String errorMessage = "未在发布方案时间段内!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
			
		//String summary = request.getParameter("summary");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String category = request.getParameter("category");
		String major = request.getParameter("major");
		
		Project pro = new Project(no,name,introduction,students_num,company_username,company_teacher,company_teacher_title,date,grade,category,major);
		
		ProjectService ps = new ProjectServiceImpl();
		if(ps.addProject(pro)){
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}else{
			String errorMessage = "发现错误，传入失败!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
		//该存进数据库
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
