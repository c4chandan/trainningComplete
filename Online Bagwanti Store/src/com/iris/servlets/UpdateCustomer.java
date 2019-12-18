package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customers;


@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		CustomerDao custDao=new CustomerDaoImpl();
		
		
	
			response.setContentType("text/html");
			Customers cust = new Customers();
			String s1=request.getParameter("cid");
			int num=Integer.parseInt(s1);
			String s2=request.getParameter("cname");
			String s4=request.getParameter("gen");
			String s3=request.getParameter("em");
			String s5=request.getParameter("city");
			String s6=request.getParameter("pass");
			
			cust.setCustomerName(s2);
			cust.setEmail(s3);
			cust.setGender(s4);
			cust.setCity(s5);
			cust.setPassword(s6);
			cust.setCustomerId(num);
			
			
			boolean a=false;
		
			try {
				
				a=custDao.updateCustomers(cust);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			if(a==true)
			{
			out.println("update Successfull");
			RequestDispatcher rd=request.getRequestDispatcher("ViewCustomers");

			rd.forward(request, response);
			}
			else
			{
				out.println("not updateted");
			}
	}

}
