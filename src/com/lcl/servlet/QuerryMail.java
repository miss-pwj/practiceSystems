package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Mailbox_Verification;
import com.lcl.service.CompanyService;
import com.lcl.service.impl.CompanyServiceImpl;

@WebServlet("/QuerryMail")
public class QuerryMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String mail=request.getParameter("umail");
		String uyzm = (String)request.getParameter("uyzm");
		String code = (String)session.getAttribute("code");
		int type=(int) session.getAttribute("type");
		if(!code.equals(uyzm)){
			System.out.println("验证码错误");
			response.sendRedirect("forgetPWD.jsp");
			return;
		}
		request.setAttribute("mail", mail);
		request.setAttribute("yzm", uyzm);
		Mailbox_Verification mv = new Mailbox_Verification(mail,type,code);
		CompanyService cs = new CompanyServiceImpl();
		//先查询数据库中是否已经存在该邮箱
		if(cs.isMailExistInMailbox_Verification(mail)){
			request.getRequestDispatcher("resetPWDByMail.jsp").forward(request, response);
			return;
		}else if(cs.addMailtoDB(mv)){
				request.getRequestDispatcher("resetPWDByMail.jsp").forward(request, response);
				return;
			}
		else{
			System.err.println("添加邮箱到数据库失败！");
			String errorMessage = "添加失败,或服务器异常,请检查输入是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
