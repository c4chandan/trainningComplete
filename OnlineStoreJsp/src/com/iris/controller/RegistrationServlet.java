package com.iris.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.dao.JspCustomerDao;
import com.iris.impl.JspCustomerDaoImpl;

import com.iris.model.JspCustomer;



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
		String s2=request.getParameter("gender");
		String s3=request.getParameter("email");
		String s4=request.getParameter("pswd");
		String s5=request.getParameter("city");
		
		JspCustomer cs=new JspCustomer();
		JspCustomerDao c=new JspCustomerDaoImpl();
		
		cs.setName(s1);
		cs.setGender(s2);
		cs.setEmail(s3);
		cs.setPassword(s4);
		cs.setCity(s5);
		boolean r= false;
		
		try
		{
			r=c.registerCustomer(cs);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	if(r==true)
	{
		HttpSession session=request.getSession();
		session.setAttribute("custObj",r);
		RequestDispatcher rd=request.getRequestDispatcher("Registrationform.jsp");
		
		rd.forward(request,response);

		
	}
	else
	{
		request.setAttribute("errormsg", "user is not registered");
		RequestDispatcher rd=request.getRequestDispatcher("RegistrationServlet");
		rd.forward(request,response);
	}
		
		
	}

}
