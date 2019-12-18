package com.iris.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iris.dao.JspCustomerDao;
import com.iris.model.JspCustomer;
import com.iris.utility.ConnectionProvider;

public class JspCustomerDaoImpl implements JspCustomerDao {
	Connection conn=ConnectionProvider.getConn();
	public boolean registerCustomer(JspCustomer cust) throws Exception {
		PreparedStatement ps = conn.prepareStatement("insert into jspcustomers values(ID.nextval,?,?,?,?,?,'customer')");
		ps.setString(1, cust.getName());
		ps.setString(2, cust.getGender());
		ps.setString(3, cust.getEmail());
		ps.setString(4, cust.getPassword());
		ps.setString(5, cust.getCity());

		int a = ps.executeUpdate();
		if (a != 0) {
			return true;
		}
		return false;

	}

	@Override
	public JspCustomer validateCustomers(String Name, String Password) throws Exception {

		PreparedStatement ps = conn.prepareStatement("select * from jspcustomers where name=? and password=?");
		ps.setString(1, Name);
		ps.setString(2, Password);
		ResultSet a = ps.executeQuery();
		
		if(a.next())
		{
			JspCustomer c=new JspCustomer();
			c.setId(a.getInt(1));
			c.setName(a.getString(2));
			c.setGender(a.getString(3));
			c.setEmail(a.getString(4));
			c.setPassword(a.getString(5));
			c.setCity(a.getString(6));
			c.setRole(a.getString(7));
			return c;
		}
		return null;
	}
	@Override
	public List<JspCustomer> viewAllCustomers() throws Exception {
	List<JspCustomer> cuslist=new ArrayList<>();
	Statement s=conn.createStatement();
	ResultSet rd=s.executeQuery("select * from jspcustomers where role='customer'");
	while(rd.next())
	{
		int id=rd.getInt(1);
		String name=rd.getString(2);
		String gender=rd.getString(3);
		String email=rd.getString(4);
		String password=rd.getString(5);
		String city=rd.getString(6);
		String role=rd.getString(7);
		
		JspCustomer c=new JspCustomer();
		c.setId(id);
		c.setName(name);
		c.setGender(gender);
		c.setEmail(email);
		c.setPassword(password);
		c.setCity(city);
		c.setRole(role);
		
		cuslist.add(c);
		
	}
		return cuslist;
	}

	@Override
	public boolean deleteCustomer(int id) throws Exception {
		PreparedStatement ps=conn.prepareStatement("delete from jspcustomers where id=?");
		ps.setInt(1, id);
		
		int a =ps.executeUpdate();
		if(a!=0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCustomers(JspCustomer cust) throws Exception {
		
		PreparedStatement ps=conn.prepareStatement("update jspcustomers set name=?,gender=?,email=?,password=?, city=? where Id=?");
		ps.setInt(1, cust.getId());
		ps.setString(2, cust.getName());
		ps.setString(3,cust.getGender());
		ps.setString(4, cust.getEmail());
		ps.setString(5, cust.getPassword());
		ps.setString(6, cust.getCity());
		
		int a=ps.executeUpdate();
		if(a!=0)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public JspCustomer getCustomers(int id) throws Exception {
		PreparedStatement ps=conn.prepareStatement("select * from jspcustomers where id=?");
		ps.setInt(1, id);
ResultSet a=ps.executeQuery();
if(a.next())
{
	JspCustomer c=new JspCustomer();
	c.setId(a.getInt(1));
	c.setName(a.getString(2));
	c.setGender(a.getString(3));
	c.setEmail(a.getString(4));
	c.setPassword(a.getString(5));
	c.setCity(a.getString(6));
	
	return c;
}
		return null;
	}

}
