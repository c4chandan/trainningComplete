package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.models.Customers;

@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Customers cust=(Customers)session.getAttribute("custObj");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<table align='center'cellpadding='5px' style='background-color:lightwheat,border-radius:2px solid red;font-size:25px;color:red;padding:5px 5px;'>");
		out.println("<tr>");
		out.println("<td style='color:black;' >Name : </td>");
		out.println("<td >"+cust.getCustomerName()+"</td>");
		out.println("</tr>");

		out.println("<td style='color:black;' >Gender : </td>");
		out.println("<td>"+cust.getGender()+"</td>");
		out.println("</tr>");
		

		out.println("<td style='color:black;' >Email : </td>");
		out.println("<td>"+cust.getEmail()+"</td>");
		out.println("</tr>");

		out.println("<td style='color:black;' >City : </td>");
		out.println("<td>"+cust.getCity()+"</td>");
		out.println("</tr>");

		
		out.println("</table>");
	
		
	}

}
