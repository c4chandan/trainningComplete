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

@WebServlet("/UpdateServlate")
public class UpdateServlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		CustomerDao custDao = new CustomerDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("mid"));
		Customers c = null;
		try {
			c = custDao.getCustomers(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		out.println("<div align='center'><hr>Details of All Customers</hr></div></br>");
		out.println("<form action='UpdateCustomer'>");
		out.println("<table border='1' align='center'>");

		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<td><input type='text' name='cid' value='"+c.getCustomerId()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>Customer_Name</th>");
		out.println("<td><input type='text' name='cname' value='"+c.getCustomerName()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>Gender</th>");
		out.println("<td><input type='text' name='gen' value='"+c.getGender()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>Email</th>");
		out.println("<td><input type='text' name='em' value='"+c.getEmail()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>City</th>");
		out.println("<td><input type='text' name='city' value='"+c.getCity()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th>Password</th>");
		out.println("<td><input type='text' name='pass' value='"+c.getPassword()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th></th>");
		out.println("<td><input type='submit' name='btn'></td>");
		out.println("</tr>");
		
		out.println("</table></form>");
	}
		
	}


