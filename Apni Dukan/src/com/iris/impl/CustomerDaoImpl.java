package com.iris.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iris.dao.CustomerDao;
import com.iris.model.Customer;
import com.iris.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {
	Connection conn = ConnectionProvider.getconn();

	@Override
	public boolean regisrationCustomer(Customer cust) throws Exception {
		PreparedStatement ps=conn.prepareStatement("insert into customer values(customerId.nextval,?,?,?,?,?,'customer')");
		ps.setString(1, cust.getCustomername());
		ps.setString(2,cust.getGender());
		ps.setString(3,	cust.getEmail());
		ps.setString(4, cust.getPassword());
		ps.setString(6, cust.getCity());
	
	int	a=ps.executeUpdate();
	if(a!=0)
	{
		return true;
	}
	return false;
	}

}
