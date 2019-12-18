package com.iris.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iris.daos.CustomerDao;
import com.iris.models.Customers;

import com.iris.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {

	Connection conn = ConnectionProvider.getConn();

	@Override
	public boolean registerCustomer(Customers cust) throws Exception {

		PreparedStatement ps = conn
				.prepareStatement("insert into Customers values(CustomersId.nextval,?,?,?,?,?,'customer')");
		ps.setString(1, cust.getCustomerName());
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
	public Customers validateCustomers(String Name, String Password) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Select * from Customers where CustomerName=? and Password=?");
		ps.setString(1, Name);
		ps.setString(2, Password);
		ResultSet a = ps.executeQuery();

		if (a.next()) {
			Customers c = new Customers();
			c.setCustomerId(a.getInt(1));

			c.setCustomerName((a.getString(2)));
			c.setGender(a.getString(3));
			c.setEmail(a.getString(4));
			c.setPassword(a.getString(5));
			c.setCity(a.getString(6));
			c.setRole(a.getString(7));

			return c;
		}
		return null;

	}

	public List<Customers> viewAllCustomers() throws Exception {
		List<Customers> customerList = new ArrayList<>();
		Statement st = conn.createStatement();
		ResultSet a = st.executeQuery("select * from Customers where role='customer'");

		while (a.next()) {
			int customerId = a.getInt(1);
			String customerName = a.getString(2);
			String gender = a.getString(3);
			String email = a.getString(4);
			String password = a.getString(5);
			String city = a.getString(6);
			String role = a.getString(7);
			System.out.println("role - " + role);

			Customers c = new Customers();
			c.setCustomerId(customerId);
			c.setCustomerName(customerName);
			c.setGender(gender);
			c.setEmail(email);
			c.setPassword(password);
			c.setCity(city);
			c.setRole(role);

			System.out.println(c);

			customerList.add(c);

		}
		return customerList;

	}

	@Override
	public boolean deleteCustomer(int id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("delete from Customers where CustomerId=?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();

		if (i != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Customers getCustomers(int id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Select * from Customers where CustomerId=?");
		ps.setInt(1, id);
		ResultSet a = ps.executeQuery();

		if (a.next()) {
			Customers c = new Customers();
			c.setCustomerId(a.getInt(1));

			c.setCustomerName((a.getString(2)));
			c.setGender(a.getString(3));
			c.setEmail(a.getString(4));
			c.setPassword(a.getString(5));
			c.setCity(a.getString(6));

			return c;
		}
		return null;
	}

	@Override
	public boolean updateCustomers(Customers cust) throws Exception {

		PreparedStatement ps = conn.prepareStatement(
				"update Customers set CustomerName=?,Gender=?,Email=?,Password=?, City=? where CustomerId=?");
		ps.setString(1, cust.getCustomerName());
		ps.setString(2, cust.getGender());
		ps.setString(3, cust.getEmail());
		ps.setString(4, cust.getPassword());
		ps.setString(5, cust.getCity());
		ps.setInt(6, cust.getCustomerId());
		int a = ps.executeUpdate();

		if (a != 0) {
			return true;
		}
		return false;
	}
}