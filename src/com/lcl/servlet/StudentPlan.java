package com.lcl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Project;
import com.lcl.entity.Project_select;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

@WebServlet("/StudentPlan")
public class StudentPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		if(!"student".equals((String)session.getAttribute("user"))){
			request.getRequestDispatcher("main.jsp").forward(request, response);
			return;
		}
		List<Project> list = new ArrayList<>();
		ProjectService ps = new ProjectServiceImpl();
		Project_select proSel = (Project_select) request.getAttribute("proSel");
		String studentNo=(String) session.getAttribute("uname");
		/*if(proSel==null){
			if(ps.isStudentChoose(studentNo)){
				request.setAttribute("sign", "已选");
			}else{
				request.setAttribute("sign", request.getAttribute("sign"));
			}
		}*/
		if(proSel!=null){
			if(ps.querryStuAndPro(proSel)){
				request.setAttribute("sign", "已选");
			}else{
				request.setAttribute("sign", request.getAttribute("sign"));
			}
		}
		list = ps.querryProject();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("studentPlan.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
