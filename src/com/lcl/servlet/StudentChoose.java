package com.lcl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Project_select;
import com.lcl.entity.System_Parameter;
import com.lcl.service.AdminService;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.AdminServiceImpl;
import com.lcl.service.impl.ProjectServiceImpl;
import com.lcl.util.DateUtils;

@WebServlet("/StudentChoose")
public class StudentChoose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AdminService as =new AdminServiceImpl();
		System_Parameter sp = as.querryDate("admin");
		Date now =new Date();
		if(!DateUtils.belongCalendar(now, sp.getStudentSelStartDate(), sp.getStudentSelEndDate())){
			String errorMessage = "当前不是选择日期!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		String No = (String)request.getParameter("proNo");
		String reason = (String) request.getParameter("reason");
		String stuNo = (String)session.getAttribute("uname");
		//System.out.println("学生选择"+stuNo+"-"+No+"-"+reason);
		//String company = (String)session.getAttribute("company");
		
		
		ProjectService prose = new ProjectServiceImpl();
		String companyUserName = prose.querryCompanyUserName(No);
		Project_select ps = new Project_select(stuNo,No,reason,companyUserName);
		request.setAttribute("proSel", ps);
		if(prose.querryStuAndPro(ps)){
			System.out.println("你已经选择了方案，可以退选,请查看你的结构退选");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		if(prose.maxNum(No)<1){
			System.err.println("人数："+prose.maxNum(No));
			request.setAttribute("err", "人数已饱满，请选择其他方案");
			request.getRequestDispatcher("StudentPlan").forward(request, response);
		}
		
		if(prose.choosePlan(ps)){
			System.out.println("选择方案成功");
			request.setAttribute("sign", "已选");
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}else{
			System.err.println("选择方案失败");
			String errorMessage = "选择失败,或服务器异常,请检查项目是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
