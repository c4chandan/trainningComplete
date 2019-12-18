package com.iris.daos;

import java.util.List;

import com.iris.models.SqlEmployee;

public interface SqlEmployeeDao {

	public boolean addEmployee(SqlEmployee e) throws Exception;

	public boolean deleteEmployee(int Id) throws Exception;

	public SqlEmployee getEmployeeById(int Id) throws Exception;

	public boolean validateEmployee(int Id, String Pass) throws Exception;

	public List<SqlEmployee> getAllEmployees() throws Exception;
}
