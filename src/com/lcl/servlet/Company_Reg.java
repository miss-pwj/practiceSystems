package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Company;
import com.lcl.entity.Mailbox_Verification;
import com.lcl.service.CompanyService;
import com.lcl.service.impl.CompanyServiceImpl;

@WebServlet("/Company_Reg")
public class Company_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String icode=request.getParameter("icode");
		String username = request.getParameter("uname");
		String componyName = request.getParameter("cname");
		String cpwd = request.getParameter("cpwd");
		String cmail = request.getParameter("cmail");
		String cyzm = request.getParameter("cyzm");
		
		
		Mailbox_Verification mv= new Mailbox_Verification(cmail,1,cyzm);
		CompanyService mvs = new CompanyServiceImpl();
		
		HttpSession session = request.getSession();
		
		String message="";
		if(mvs.selectInviteCode().equals(icode)){//邀请码正确
			if(session.getAttribute("regCode").equals(cyzm)){//验证码正确
				mvs.addMailtoDB(mv);
				System.err.println("添加邮箱成功");
			}else{
				 message="验证码错误";
				request.setAttribute("message", message);
				request.getRequestDispatcher("company_Reg.jsp").forward(request, response);
				return;
			}
		}else{
			 message="邀请码错误";
			request.setAttribute("message", message);
			request.getRequestDispatcher("company_Reg.jsp").forward(request, response);
			return;
		}
		Company com = new Company(username,componyName,cmail,cpwd);
		if(mvs.addCompony(com)){
			message="注册成功,请登录";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
