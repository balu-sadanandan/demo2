package com.test;
import java.sql.*;



public class jdbcdemo {
	
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/emp_db";
		String username = "root";
		String password = "1234";
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		
		String sql = "INSERT INTO emp_table  VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "3");
		statement.setString(2, "billgates");
		statement.setString(3, "12345");
		statement.setString(4, "bill.gates@microsoft.com");
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
		
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	}

}
