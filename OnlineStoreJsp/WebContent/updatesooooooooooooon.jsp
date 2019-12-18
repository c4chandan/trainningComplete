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

import com.iris.models.Customer;

@WebServlet("/GetCustomerDetails")
public class GetCustomerDetails extends HttpServlet {
                private static final long serialVersionUID = 1L;

                                Customer cust =new Customer();
                                
                                
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                
                                response.setContentType("text/html");
                                PrintWriter out=response.getWriter();
                                int id=Integer.parseInt(request.getParameter("id"));
                                String name=request.getParameter("name");
                                String pwd=request.getParameter("pwd");
                                String gender=request.getParameter("gender");
                                String age=request.getParameter("age");
                                String city=request.getParameter("city");
                                int a=Integer.parseInt(age);
                                
                                cust.setName(name);
                                cust.setAge(a);
                                cust.setPassword(pwd);
                                cust.setCity(city);
                                cust.setGender(gender);
                
                                CustomerDao obj=new CustomerDaoImpl();
                                
                                
                                 if (id!=0) {
                                                try {
                                                                                boolean b= obj.update(id, name,  city, a);
                                                                                if (b==true) {
                                                                                                
                                                                                                request.setAttribute("msg", "User Updated Successfully ");
                                                                                                                                
                                                                                                request.setAttribute("customerList", obj.printDetailsForAdmin());
                                                                                                RequestDispatcher rd=request.getRequestDispatcher("CustomersList.jsp");
                                                                                                rd.forward(request,response);
                                                                                                
                                                                                }
                                                                                else {
                                                                                                
                                                                                                out.println("Problem in updating ");
                                                                                                out.println("<br><br><br><br><br><br><br><br>");
                                                                                                
                                                                                                RequestDispatcher rd=request.getRequestDispatcher("CustomersList.jsp");
                                                                                                rd.include(request,response);
                                                                                }
                                                                                
                                                                } catch (Exception e) {
                                                                
                                                                                e.printStackTrace();
                                                                }
                                                
                                 }
                                
                                 else {
                                try { 
                                                 int r = obj.registerCustomer(cust);
                                
                                                if(r!=0){
                                                                out.println("You are registered Sucessfully with customer id : "+r);
                                                                out.println("<a href='login.html'>Login</a> ");
                                                
                                                }
                                                else {
                                                                out.println("Problem in registration");
                                                
                                                }
                                } 
                                                catch (Exception e) {
                                                                
                                                                e.printStackTrace();
                                                }
                }
                }
}









<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align:center;">Enter your Details</h2>
<div align="center"style="padding:25px;padding-left:200px;padding-right:200px;">
        <fieldset>
       
                <form action="GetCustomerDetails" >

                       <table>
                       
                                  <c:if test="${not empty Cobj}">
                                  <tr>
                                  <td>Id :</td>
                               <td> <input type="text" id="id" name="id" class="form-control" value="${Cobj.cust_id}" placeholder="Id"></td>
                                                </tr>
                                                </c:if>
                                                
                                                
                           <tr>
                                  <td>Name :</td>
                               <td> <input type="text" id="name" name="name" class="form-control" value="${Cobj.name}" placeholder="Name"></td>
                                                </tr>
                                                <c:if test="${empty Cobj}"> 
                           <tr>
                           
                                <td>Gender :  </td>

                                 <td>  <input id="gender" type="radio" name="gender" value="M" />Male
                                    <input id="gender" type="radio" name="gender" value="F"  />Female</td>
                           </tr>
                           </c:if>  
                            <c:if test="${not empty Cobj}">
                            <tr>
                            <td>Gender :  </td> <td> <input type="text" id="gender" name="gender"  value="${Cobj.gender}" placeholder="gender"></td>
                               
                           </tr>
                           </c:if>  
                           <tr>
                           <td>Age :</td>
                       
                       <td> <input type="text" id="age"  name="age"  placeholder="Age " value="${ Cobj.age}"></td>
                    
                       </tr>
                       
                       <c:if test="${empty Cobj}">     
                       <tr>
                       <td>Password :</td> <td><input type="password"  id="pwd" name="pwd" placeholder="Password"></td>
                      </tr>
                      </c:if>
                    
                    <c:if test="${empty Cobj}"> 
                    <tr>
                      <td>City :</td>  
                      <td>  
                           <select name="city" >
                        <option value="none" >  Select your city </option>
                        <option value="delhi"> Delhi </option>
                        <option value="noida"> Noida </option>
                        <option value="gurgaon"> Gurgaon </option>
                        <option value="chennai"> Chennai  </option>
                      
                    </select>
                    </td>
                            </tr>
                           </c:if>
                       <c:if test="${not empty Cobj}">    
                    <tr>
                      <td>City :</td>    <td> <input type="text" id="city" name="city"  value="${Cobj.city}" placeholder="city"></td>
                    </tr>
                       </c:if>
                   </table>
                   
                   <c:if test="${empty Cobj}">
                    <button type="submit">Sign up</button>
                    </c:if>
                    
                    <c:if test="${not empty Cobj}">
                    <button type="submit">Update</button>
                    </c:if>
                    
                    </form>
</fieldset>
</div>
</body>
</html>

l>