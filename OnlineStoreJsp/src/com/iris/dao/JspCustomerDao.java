package com.iris.dao;

import java.util.List;

import com.iris.model.JspCustomer;

public interface JspCustomerDao {
	
	public boolean registerCustomer(JspCustomer cust) throws Exception;
	public JspCustomer validateCustomers(String Name, String Password) throws Exception;
	public List<JspCustomer> viewAllCustomers() throws Exception;

	public boolean deleteCustomer (int id) throws Exception;
	
 public	boolean updateCustomers(JspCustomer cust) throws Exception;
 public JspCustomer getCustomers(int id) throws Exception;



}
