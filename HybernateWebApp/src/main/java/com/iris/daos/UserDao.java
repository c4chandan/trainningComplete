package com.iris.daos;


import java.util.List;

import com.iris.model.Address;
import com.iris.model.User;

public interface UserDao {


	public boolean registerCustomer(User cust) ;

	public User validateCustomers(String userName, String Password);
	public List<User> viewAllCustomers();

	public boolean deleteCustomer (int id);
	
 public	User updateCustomers(User cust);
 public User getCustomers(int id) ;
 
 public List<User> ViewAddress(Address  a);
}
