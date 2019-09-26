package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class IsAuditServlet
 */
@WebServlet("/IsAuditServlet")
public class IsAuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IsAuditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		ProjectService ps = new ProjectServiceImpl();
		PrintWriter out = response.getWriter();
		if(ps.isAudit(no)){
			out.write(" {\"msg\":\"true\"}");
			return;
		}else{
			out.write(" {\"msg\":\"false\"}");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
