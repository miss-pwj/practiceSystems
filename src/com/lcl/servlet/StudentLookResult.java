package com.lcl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.service.ProjectService;
import com.lcl.service.StudentService;
import com.lcl.service.impl.ProjectServiceImpl;
import com.lcl.service.impl.StudentServiceImpl;

@WebServlet("/StudentLookResult")
public class StudentLookResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String stuNo = (String) request.getSession().getAttribute("uname");
		System.out.println("lookResult:"+stuNo);
		//学生查看结果
		StudentService ss = new StudentServiceImpl();
		List<String> list = new ArrayList<>();
		list = ss.querryPlan(stuNo);
		
		request.setAttribute("plan", list);
		ProjectService proSer = new ProjectServiceImpl();
		for(String proNo:list){
			System.out.println("proNo");
			if(proSer.IsStudentChoose(stuNo, proNo)){
				request.setAttribute("choose", proNo);
				System.out.println(proNo);
			}
		}
		
		request.getRequestDispatcher("studentResult.jsp").forward(request, response);
		System.out.println("学生查看结果");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
