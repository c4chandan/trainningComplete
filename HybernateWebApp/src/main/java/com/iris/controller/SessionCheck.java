package com.iris.controller;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheck
 */
public class SessionCheck implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		response.setContentType("text/html");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else {
		chain.doFilter(request, response);
	}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
