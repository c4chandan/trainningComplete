package com.iris.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.dao.JspCustomerDao;
import com.iris.impl.JspCustomerDaoImpl;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		JspCustomerDao dao=new JspCustomerDaoImpl();
		String id=request.getParameter("cid");
		int num=Integer.parseInt(id);
		
		boolean r=false;
		try {
			r=dao.deleteCustomer(num);
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		if(r==true)
		{
		RequestDispatcher rd=request.getRequestDispatcher("getAllCustomer");
		rd.forward(request, response);
		}
		else
		{
		  request.setAttribute("msg", "User can't be delated");
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
