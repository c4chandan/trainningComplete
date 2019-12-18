package com.iris.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.UserDaoImpl.UserDaoImpl;

import com.iris.daos.UserDao;


import com.iris.model.User;



@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");	
			
		
		
		String s1=request.getParameter("cname").toLowerCase();
		String s2=request.getParameter("pswd");
		String s3=request.getParameter("gender");
		String s4=request.getParameter("email");
		
		User cs=new User();
		UserDao c=new UserDaoImpl();
		
		cs.setUserName(s1);
		cs.setPassword(s2);
		cs.setGender(s3);
		cs.setEmail(s4);
			boolean r= false;
		
		try
		{
			r=c.registerCustomer(cs);
			
		}
		catch (Exception e) {
			
		e.printStackTrace();
		}
	if(r==true)
	{
		HttpSession session=request.getSession();
		session.setAttribute("custobj",r);
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		
		rd.forward(request,response);

		
	}
	else
	{
		request.setAttribute("errormsg", "user is not registered");
		RequestDispatcher rd=request.getRequestDispatcher("Registrationform.jsp");
		rd.forward(request,response);
	}
		
		
	}

}
