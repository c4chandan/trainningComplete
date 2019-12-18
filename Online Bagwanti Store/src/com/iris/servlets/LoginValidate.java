package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customers;

@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		CustomerDao dao = new CustomerDaoImpl();
		String s1 = request.getParameter("Name");
		String s2 = request.getParameter("Password");

		Customers r = null;
		try {
			r = dao.validateCustomers(s1,s2);
		

		}
		catch (Exception e) {

			e.printStackTrace();
		}
		if (r!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("custObj",r);
			if(r.getRole().equals("customer"))
			{
			RequestDispatcher rd=request.getRequestDispatcher("valid");
			rd.forward(request,response);
			}
		else if (r.getRole().equals("admin")){
			RequestDispatcher rd=request.getRequestDispatcher("AdminSevlet");
			rd.forward(request, response);
			}
		}		
		else
		{
			out.println("Invalid user");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}
	
	}
	}

