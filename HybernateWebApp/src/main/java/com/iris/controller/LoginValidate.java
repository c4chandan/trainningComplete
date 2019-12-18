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

/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginValidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	
		UserDao custdao = new UserDaoImpl();

		String s1 = request.getParameter("userName");
		
		String s2 = request.getParameter("Password");

		User r = null;
		try {
			r = custdao.validateCustomers(s1,s2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (r != null) {
			HttpSession session = request.getSession();
			session.setAttribute("custobj", r);
			if (r.getRole().equals("customer")) {
				RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
				rd.forward(request, response);
			} else if (r.getRole().equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			} 
		}
			else {

				request.setAttribute("msg", "You have entered the wrong Id and Password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
		
		
			}
		

	}

}
