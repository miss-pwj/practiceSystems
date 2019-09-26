package com.lcl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.entity.Project;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

@WebServlet("/GetPlanNo")
public class GetPlanNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ProjectService ps = new ProjectServiceImpl();
		List<Project> list = new ArrayList<>();
		list=ps.querryProject();
		String way=(String) request.getAttribute("way");
		if(way==null){
			way="0";
		}
		request.setAttribute("way", way);
		request.setAttribute("list", list);
		request.getRequestDispatcher("showPlanNo.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
