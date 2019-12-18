package com.iris.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iris.UserDaoImpl.UserDaoImpl;
import com.iris.daos.UserDao;
import com.iris.model.Address;
import com.iris.model.User;

public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String s1 = request.getParameter("State");
		String s2 = request.getParameter("city");
		String s3 = request.getParameter("pincode");

		
		Address ad = new Address();
		ad.setState(s1);
		ad.setCity(s2);
		ad.setPincode(s3);
		
		HttpSession session=request.getSession();
		User uObj=(User)session.getAttribute("custobj");
		
		Set<Address> addrs=uObj.getAddresSet();
		addrs.add(ad);
		
		uObj.setAddresSet(addrs);

		UserDao daoObj = new UserDaoImpl();
		User r = null;
		try {
			r = daoObj.updateCustomers(uObj);
			System.out.println("Address Updated : "+r);
		}
		 catch (Exception e) {
				e.printStackTrace();
			}

		
		if(r!=null)
		{
			request.setAttribute("addo?bj",r);
			request.setAttribute("msg", "Address is added Successfully");
			
			RequestDispatcher rd=request.getRequestDispatcher("ShowAddress.jsp");
			
			rd.forward(request,response);

			
		}
		
		
	}

}
