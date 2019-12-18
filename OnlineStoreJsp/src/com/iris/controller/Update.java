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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		JspCustomerDao dao=new JspCustomerDaoImpl();
		String s1=request.getParameter("mid");
		int num=Integer.parseInt(s1);
		JspCustomer r=null;
		
		try {
			r=dao.getCustomers(num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(r!=null)
		{
			request.setAttribute("upone", r);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("null value");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
