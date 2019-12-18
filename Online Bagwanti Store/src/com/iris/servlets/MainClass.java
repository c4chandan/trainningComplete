package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customers;


@WebServlet("/MainClass")
public class MainClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");	
	PrintWriter out=response.getWriter();
	
	CustomerDao c=new CustomerDaoImpl();
	
	String s1=request.getParameter("cname");
	String s2=request.getParameter("gender");
	String s3=request.getParameter("email");
	String s4=request.getParameter("pswd");
	String s5=request.getParameter("city");
	
	Customers cs=new Customers();
	
	cs.setCustomerName(s1);
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
	
	out.println("customer register");
	
}
else
{
	out.println("not registered");
}
	
	}

}
