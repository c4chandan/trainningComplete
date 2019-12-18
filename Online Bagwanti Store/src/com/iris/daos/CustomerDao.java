package com.iris.daos;

import java.util.List;

import com.iris.models.Customers;

public interface CustomerDao {

	
	
	public boolean registerCustomer(Customers cust) throws Exception;
	public Customers validateCustomers(String Name, String Password) throws Exception;
	public List<Customers> viewAllCustomers() throws Exception;

	public boolean deleteCustomer (int id) throws Exception;
	
 public	boolean updateCustomers(Customers cust) throws Exception;
 public Customers getCustomers(int id) throws Exception;


	

}
