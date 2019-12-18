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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        CustomerDao objDao=new CustomerDaoImpl();
      String id=request.getParameter("cid");
      int n=Integer.parseInt(id);
      boolean r= false;
      try{
    	  	r=objDao.deleteCustomer(n);
      }
catch(Exception e)
      {
	e.printStackTrace();
      }
      if (r==true)
      {
    	  RequestDispatcher rd=request.getRequestDispatcher("ViewCustomers");
    	  rd.include(request, response);
      }
      else
      {
    	  out.println("not delted");
      }
	}

}
