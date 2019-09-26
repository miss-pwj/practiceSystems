package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.util.EmailUtils;

@WebServlet("/IsCodeTrue")
public class IsCodeTrue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		HttpSession session = request.getSession();
//		String yzm = request.getParameter("uyzm");
		String mail = request.getParameter("umail");
		
		String code=EmailUtils.sendMail();
		PrintWriter out = response.getWriter();
		if(mail==null){
			out.write(" {\"msg\":\"null\"}");
			return;
		}else{
			out.write(" {\"msg\":\"true\"}");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
