package com.web.MVCMavenWebDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class IdFilter
 */
@WebFilter("/ControllerServlet")
public class IdFilter implements Filter {

  	public void destroy() {
		// TODO Auto-generated method stub
	}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
			PrintWriter out = response.getWriter();
			
			HttpServletRequest req = (HttpServletRequest)request;
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(id>0) {
				chain.doFilter(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");  
	            rd.forward(request, response); 
			}
			
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
