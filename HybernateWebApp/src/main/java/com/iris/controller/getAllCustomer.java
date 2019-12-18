package com.iris.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.UserDaoImpl.UserDaoImpl;
import com.iris.daos.UserDao;
import com.iris.model.User;

/**
 * Servlet implementation class getAllCustomer
 */
@WebServlet("/getAllCustomer")
public class getAllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
			UserDao dao=new UserDaoImpl();
		List<User> a=new ArrayList<User>();
		
		try {
			a=dao.viewAllCustomers();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		if(a!=null)
		{
			request.setAttribute("custobj", a);
			RequestDispatcher rd=request.getRequestDispatcher("viewAllCustomer.jsp");
			rd.forward(request, response);
					
		}
		}

}
