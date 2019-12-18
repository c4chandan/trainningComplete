package com.iris.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iris.daos.SqlEmployeeDao;
import com.iris.models.SqlEmployee;
import com.iris.utility.ConnectionProvider;

public class SqlEmployeeDaoimpl implements SqlEmployeeDao {
	Connection conn = ConnectionProvider.getConn();

	@Override
	public boolean addEmployee(SqlEmployee e) throws Exception {
		PreparedStatement ps = conn.prepareStatement("insert into SqlEmployee values(?,?,?,?) ");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getPassword());
		ps.setString(4, e.getGender());
		int a = ps.executeUpdate();
		if (a != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int Id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Delete from SqlEmployee where id=?");
		ps.setInt(1, Id);
		int a = ps.executeUpdate();

		if (a != 0) {
			return true;
		}
		return false;
	}

	@Override
	public SqlEmployee getEmployeeById(int Id) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Select * from SqlEmployee where id=?");
		ps.setInt(1, Id);

		ResultSet a = ps.executeQuery();

		if (a.next()) {
			int id = a.getInt(1);
			String name = a.getString(2);
			String password = a.getString(3);
			String gender = a.getString(4);

			SqlEmployee emp = new SqlEmployee();
			emp.setId(id);
			emp.setName(name);
			emp.setPassword(password);
			emp.setGender(gender);
			return emp;
		}

		return null;
	}

	@Override
	public boolean validateEmployee(int Id, String Pass) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Select * from SqlEmployee where id=? and password=?");
		ps.setInt(1, Id);
		ps.setString(2, Pass);
		ResultSet a = ps.executeQuery();

		if (a.next()) {

			return true;
		}

		return false;
	}

	@Override
	public List<SqlEmployee> getAllEmployees() throws Exception {

		List<SqlEmployee> emplist = new ArrayList<>();

		Statement s = conn.createStatement();
		ResultSet a = s.executeQuery("Select * from SqlEmployee");

		while (a.next()) {
			int id = a.getInt(1);
			String name = a.getString(2);
			String password = a.getString(3);
			String gender = a.getString(4);

			SqlEmployee emp = new SqlEmployee();
			emp.setId(id);
			emp.setName(name);
			emp.setPassword(password);
			emp.setGender(gender);

			emplist.add(emp);

		}
		return null;

	}
}