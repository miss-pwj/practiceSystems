package com.lcl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.service.CompanyService;
import com.lcl.service.StudentService;
import com.lcl.service.impl.CompanyServiceImpl;
import com.lcl.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ChangePWD
 */
@WebServlet("/ChangePWDByMail")
public class ChangePWDByMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		String fpwd = request.getParameter("fpwd");
		String spwd = request.getParameter("spwd");
		String mail = (String) session.getAttribute("mail");

		String user = (String) session.getAttribute("user");
		String uname = (String) session.getAttribute("uname");
		StudentService ss = new StudentServiceImpl();
		CompanyService cs = new CompanyServiceImpl();
		/*if ("student".equals(user)) {
			if (ss.checkIsPwdSame(uname, fpwd)) {
				System.out.println("新密码不能与旧密码相同");
				String errorMessage = "新密码不能与旧密码相同!";
				request.getSession().setAttribute("ErrorMessage", errorMessage);
				response.sendRedirect(request.getContextPath() + "/404.jsp");
			}
		} else if ("company".equals(user)) {
			if (cs.checkIsPwdSame(uname, fpwd)) {
				System.out.println("新密码不能与旧密码相同");
				String errorMessage = "新密码不能与旧密码相同!";
				request.getSession().setAttribute("ErrorMessage", errorMessage);
				response.sendRedirect(request.getContextPath() + "/404.jsp");

			}
		}*/


		if (cs.changePwdByMail(fpwd,mail)) {
			System.out.println("修改密码成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else if (ss.changePwdByMail(fpwd,mail)) {
			System.out.println("修改密码成功");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		} else {
			String errorMessage = "修改密码失败,或邮箱不存在,请检查输入是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
