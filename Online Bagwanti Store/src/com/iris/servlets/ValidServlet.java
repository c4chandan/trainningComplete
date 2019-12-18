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


@WebServlet("/valid")
public class ValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidServlet() {
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
		
		HttpSession session=request.getSession();
		Customers cust=(Customers)session.getAttribute("custObj");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	

		out.println("<table align='center'cellpadding='5px' style='background-color:lightwheat,border-radius:2px solid red;font-size:20px;color:red;'>");
		out.println("<tr>");
		out.println("<td style='color:black;' >Welcome :</td>");
		out.println("<td >"+cust.getCustomerName()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td ><a href='ViewProfile'>View Profile</a></td>");
		out.println("</tr>");

		out.println("</table>");
		
	
	}
	

}
