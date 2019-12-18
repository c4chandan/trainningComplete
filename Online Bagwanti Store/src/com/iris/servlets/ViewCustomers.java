package com.iris.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iris.daos.CustomerDao;
import com.iris.daosimpl.CustomerDaoImpl;
import com.iris.models.Customers;

/**
 * Servlet implementation class ViewCustomers
 */
@WebServlet("/ViewCustomers")
public class ViewCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        CustomerDao objDao=new CustomerDaoImpl();
               try {
               List<Customers> rs=new ArrayList<>();
               rs=objDao.viewAllCustomers();
               out.println("<table cellpadding='5px' cellspacing='5px;'  Style='font-size:20px;padding:20px;'>");
               out.println("<tr>");
               out.println("<th> ID</th>");
               out.println("<th>Name</th>");
               out.println("<th>Password</th>");
               out.println("<th>EmailId</th>");
               out.println("<th>City</th>");
               out.println("<th>Gender</th>");
               out.println("<th>Role</th>");
               
               for(Customers c1:rs) {
         out.println("<tr>");      
               out.println("<td>"+c1.getCustomerId()+"</br></td>");
               out.println("<td>"+c1.getCustomerName()+"</br></td>");
               out.println("<td>"+c1.getPassword()+"</br></td>");
               out.println("<td>"+c1.getEmail()+"</br></td>");
               out.println("<td>"+c1.getCity()+"</br></td>");
               out.println("<td>"+c1.getGender()+"</br></td>");
               out.println("<td>"+c1.getRole()+"</br></td>");
               out.println("<td> <a href='UpdateServlate?mid="+c1.getCustomerId()+"'>Update</a></br></td>");
               out.println("<td> <a href='Delete?cid="+c1.getCustomerId()+"'>Delete</a></br></td>");
               out.println("</tr>");
               }
               out.println("</table>");   
        } 
               catch (Exception e) {
               e.printStackTrace();
              
        }
               

	}

}
