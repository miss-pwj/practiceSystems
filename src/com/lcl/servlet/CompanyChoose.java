package com.lcl.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lcl.entity.Project_select;
import com.lcl.service.ProjectService;
import com.lcl.service.impl.ProjectServiceImpl;
import com.lcl.util.PageUtils;

@WebServlet("/CompanyChoose")
public class CompanyChoose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*HttpSession session = request.getSession();
		String studentNo=(String) request.getParameter("studentNo");
		Date time = DateUtils.splitStringToDate((String) request.getParameter("time"));
		String companyName=(String) request.getParameter("companyName");
		Project_select ps = new Project_select(studentNo);
		ProjectService proSer = new ProjectServiceImpl();
		if(proSer.querryStuAndPro(ps)){
			ps.setCompanyName(companyName);
			ps.setCompanySelDate(time);
			if(proSer.chooseStudent(ps)){
				System.out.println("选择成功");
				request.getRequestDispatcher("main.jsp").forward(request, response);
				return;
			}
		}else{
			System.out.println("该学生没有选择方案");
			response.sendRedirect("main.jsp");
		}*/
		
		/*全部查询
		 * 
		 * ProjectService ps = new ProjectServiceImpl();
		List<Project_select> list = ps.studentWithPlan();*/
		
		int currentPage = request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = request.getParameter("pageSize")==null?5:Integer.parseInt(request.getParameter("pageSize"));
		
		ProjectService ps = new ProjectServiceImpl();
		//查询总记录数
		int totalSize = ps.totalSizeOfProject_select();
		
		PageUtils pages = new PageUtils(currentPage, pageSize,totalSize);
		request.setAttribute("p", pages);
		List<Project_select> list = ps.studentWithPlan(currentPage,pageSize);
		request.setAttribute("list", list);
		//request.getSession().setAttribute("may", "company");
		request.getRequestDispatcher("companyChoose.jsp").forward(request, response);
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
