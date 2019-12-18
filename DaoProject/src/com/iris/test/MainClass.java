package com.iris.test;

import com.iris.daosimpl.SqlEmployeeDaoimpl;
import com.iris.models.*;
import com.iris.utility.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.iris.daos.*;

public class MainClass {

	static Scanner sc= new Scanner(System.in);
	
	static SqlEmployeeDao empobj=new SqlEmployeeDaoimpl();
	static Connection conn = ConnectionProvider.getConn();

	
	public static void insertSqlEmployee() throws Exception
	{

		System.out.println("=================Enter your Details===================== ");
		System.out.println("Enter the User id");
		int id = sc.nextInt();
		System.out.println("Enter the User Name");
		String name= sc.next();
		System.out.println("Enter the User password");
		String password= sc.next();
		System.out.println("Enter the User Gender");
		String gender= sc.next();
		
		
		
		SqlEmployee emp=new SqlEmployee();
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setGender(gender);
		
		boolean r=empobj.addEmployee(emp);
		if(r==true)
		{
			System.out.println("user is added");
		}
		else
		{
			System.out.println("user is not added");
		}
	}
	
	public static void DeleteSqlEmployee() throws Exception
	{
		System.out.println("=================Enter your Id to delete===================== ");
		int uid = sc.nextInt();

		PreparedStatement ps = conn.prepareStatement("delete from SqlEmployee where id=?");
		ps.setInt(1, uid);

		int i = ps.executeUpdate();
		if (i == 0) {
			System.out.println("User not Deleted");

		}

		else {
			System.out.println("User DELETED successfully...........");
		}
	}
	
	public static void getEmployeeDetails() throws Exception
	{
		System.out.println("=================Enter your Id to getEmployee Id===================== ");
		int uid=sc.nextInt();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from SqlEmployee where id= " + uid);
		if (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		} else {
			System.out.println("Employee with this" + uid + "Doesnot exit");
		}


		
	}

 public static void main(String []args)
 {
	 try {

			System.out.println("=================Enter your Choice===================== ");
			System.out.println("Enter 1 for Insert");
			System.out.println("Enter 2 for Delete");
			System.out.println("Enter 3 for getEmployeeDetails");
			System.out.println("Enter 4 for validate");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				insertSqlEmployee();
				break;
			case 2:
				DeleteSqlEmployee();
				break;

			case 3:
		getEmployeeDetails();
				break;
			case 4:
			//	ValidateSqlEmployee();
				break;
			default:
				System.out.println("Invalid choice");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
 }
}