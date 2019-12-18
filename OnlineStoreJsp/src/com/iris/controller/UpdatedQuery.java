package com.iris.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.dao.JspCustomerDao;
import com.iris.impl.JspCustomerDaoImpl;
import com.iris.model.JspCustomer;

/**
 * Servlet implementation class UpdatedQuery
 */
@WebServlet("/UpdatedQuery")
public class UpdatedQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatedQuery() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		JspCustomerDao cdao = new JspCustomerDaoImpl();
		String s1 = request.getParameter("id");
		int num = Integer.parseInt(s1);
		String s2 = request.getParameter("cname");
		String s3 = request.getParameter("gender");
		String s4 = request.getParameter("email");
		String s5 = request.getParameter("pswd");
		String s6 = request.getParameter("city");

		JspCustomer r = new JspCustomer();

		r.setId(num);
		r.setName(s2);
		r.setGender(s3);
		r.setEmail(s4);
		r.setPassword(s5);
		r.setCity(s6);
		boolean a = false;

		try {

			a = cdao.updateCustomers(r);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if(a==true)
		{
			out.println("Updated Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("viewAllCustomer.jsp");
					rd.forward(request, response);
		}
		else
		{
			out.println("not updated");
		}
	}

}
