package examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	static Connection con = null;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void insertSqlEmployee() throws Exception {
		System.out.println("Enter the User details:- Id,name,password,gender ");
		int uid = Integer.parseInt(br.readLine());
		String fname = br.readLine();
		String upass = br.readLine();
		String gender = br.readLine();

		PreparedStatement ps = con.prepareStatement("insert into SqlEmployee values(?,?,?,?)");
		ps.setInt(1, uid);
		ps.setString(2, fname);
		ps.setString(3, upass);
		ps.setString(4, gender);

		int i = ps.executeUpdate();
		if (i == 0) {
			System.out.println("USer not inserted");

		}

		else {
			System.out.println("User inserted successfully...........");
		}

	}

	static void DeleteSqlEmployee() throws Exception {
		System.out.println("Enter the User id that You want to delete");
		int uid = Integer.parseInt(br.readLine());

		PreparedStatement ps = con.prepareStatement("delete from SqlEmployee where id=?");
		ps.setInt(1, uid);

		int i = ps.executeUpdate();
		if (i == 0) {
			System.out.println("User not Deleted");

		}

		else {
			System.out.println("User DELETED successfully...........");
		}
	}

	static void getEmployeeDetails() throws Exception {
		System.out.println("Enter the User id");
		int uid = Integer.parseInt(br.readLine());

		PreparedStatement ps = con.prepareStatement("select * from SqlEmployee where id=?");
		ps.setInt(1, uid);

		int i = ps.executeUpdate();
		if (i == 0) {
			System.out.println("USer not inserted");
		} else {
			System.out.println("user available");
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from SqlEmployee where id= " + uid);
		if (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		} else {
			System.out.println("Employee with this" + uid + "Doesnot exit");
		}
	}

	static void ValidateSqlEmployee() throws Exception {
		System.out.println("Enter the User details:- Id,password ");
		System.out.println("Enter your id");
		int uid = Integer.parseInt(br.readLine());
		System.out.println("Enter your password");
		String upass = br.readLine();

		PreparedStatement ps = con.prepareStatement("select * from SqlEmployee where id=? and password=?");
		ps.setInt(1, uid);
		ps.setString(2, upass);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("USer  verified");

		} else {
			System.out.println("not verified");
		}

	}

	public static void main(String[] args) {
		try {

			System.out.println("=================Enter the User Gender===================== ");
			System.out.println("Enter 1 for Insert");
			System.out.println("Enter 2 for Delete");
			System.out.println("Enter 3 for getEmployeeDetails");
			System.out.println("Enter 4 for validate");
			int choice = Integer.parseInt(br.readLine());
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
				ValidateSqlEmployee();
				break;
			default:
				System.out.println("Invalid choice");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
