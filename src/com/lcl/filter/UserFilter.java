package com.lcl.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(filterName="UserFilter",urlPatterns={"/main.jsp"})
public class UserFilter implements Filter {

    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res =  (HttpServletResponse)response;
			System.out.println(req.getSession().getAttribute("user")+","+req.getSession().getAttribute("uname"));
		if(req.getSession().getAttribute("user")==null||req.getSession().getAttribute("uname")==null){
			String errorMessage = "用户非法访问程序!";
			req.getSession().setAttribute("ErrorMessage", errorMessage);
			res.sendRedirect(req.getContextPath() + "/404.jsp");
			return;
		}else{
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
