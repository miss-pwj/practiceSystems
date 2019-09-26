package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IsPwdSame")
public class IsPwdSame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String fPwd = request.getParameter("fpwd");
		String sPwd = request.getParameter("spwd");
		System.out.println(fPwd+","+sPwd);
		PrintWriter out = response.getWriter();
		if(fPwd==null||sPwd==null){
			System.out.println("未输入密码");
			out.write("{\"exist\":\"null\"}");
			return;
		}
		if(!fPwd.equals(sPwd)){
			out.write("{\"exist\":\"false\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
