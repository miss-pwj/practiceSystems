package com.lcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Company;
import com.lcl.entity.Student;
import com.lcl.entity.System_Parameter;
import com.lcl.service.AdminService;
import com.lcl.service.CompanyService;
import com.lcl.service.StudentService;
import com.lcl.service.impl.AdminServiceImpl;
import com.lcl.service.impl.CompanyServiceImpl;
import com.lcl.service.impl.StudentServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uname = request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String uyzm=request.getParameter("uyzm");
		String user=request.getParameter("user");
		HttpSession session = request.getSession();
		if(!session.getAttribute("code").equals(uyzm)||user==null){
			System.out.println("验证码："+session.getAttribute("code")+","+uyzm);
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		PrintWriter out = response.getWriter();
		//存储当前的操作对象
		session.setAttribute("uname", uname);
		session.setAttribute("user", user);
		System.err.println("用户："+user);
		if("student".equals(user)){
			//学生登录
			StudentService sts = new StudentServiceImpl();
			Student student  = new Student(uname,upwd);
			if(sts.studentLogin(student)){
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			}else{
				response.sendRedirect("login.jsp");
				return;
			}
			
		}else if("company".equals(user)){
			//公司登录
			CompanyService comSer = new CompanyServiceImpl();
			Company com = new Company(uname,upwd);
			if(comSer.companyLogin(com)){
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			}else{
				System.out.println("用户名或密码错误");
				out.println("<script>alert('用户名或密码错误');history.back()</script>");
			//	response.sendRedirect("login.jsp");
				return;
			}
		}else if("admin".equals(user)){
			//管理员登录
			AdminService as = new AdminServiceImpl();
			System_Parameter admin  =new System_Parameter(uname,upwd);
			if(as.adminLogin(admin)){
				System.out.println("有问题？");
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			}else{
				response.sendRedirect("login.jsp");
				return;
			}
		}else{
			System.out.println("登录失败");
			String errorMessage = "登录失败,或服务器异常,请检查输入是否正确!";
			request.getSession().setAttribute("ErrorMessage", errorMessage);
			response.sendRedirect(request.getContextPath() + "/404.jsp");
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
