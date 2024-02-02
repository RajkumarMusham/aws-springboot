package com.spring.aws;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter into Main method");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://mysqldb-1.crmkos40qcpg.ap-southeast-2.rds.amazonaws.com:3306/mysqldb", "admin",
					"admin123");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book where id =13");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
