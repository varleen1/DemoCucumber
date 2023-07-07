package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

	public String getUser(String id) {
		String name = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Mysql@123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select username from user where personid = '" + id + "'");
			while (rs.next()) {
				name = rs.getString(1);
			} 	
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return name;

	}
	
	public int getUserID(String name) {
		int num = 0 ;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Mysql@123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select personid from user where username = '" + name + "'");
			while (rs.next()) {
				num = rs.getInt(1);
			} 	
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return num;

	}

	public void updateUser(String id) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Mysql@123");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update user set password = '111' where personid = '" + id + "'");
			// while (rs.next())
			// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
			// rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
