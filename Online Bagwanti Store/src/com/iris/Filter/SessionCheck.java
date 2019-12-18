package com.iris.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/SessionCheck")
public class SessionCheck implements Filter {

  
    public SessionCheck() {
        
    }

	
	public void destroy() {
		System.out.println("U destroyed me");
	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Preprocessing filter");
		chain.doFilter(request, response);
		System.out.println("postprocessing Filter");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter is intialize");

	}

}
