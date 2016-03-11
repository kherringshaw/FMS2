package com.fms2.dal;


import java.sql.*;

public class DBHelper {
	static String url = "jdbc:mysql://localhost:3306/fms";
	static String username = "root";
	static String password = "fpl350clark";
	static Connection connection;
	
	public static void DBHelper(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("driver exists");
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection() {
		
		System.out.println("Connecting database...");
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!");
			}
			catch(SQLException e) {
				
				System.out.println("DBHelper: Connection Failed! Check output console");
				e.printStackTrace();
				return null;
			    
			}
		
		return connection;

	}
	

	private void displaySQLErrors(SQLException e) {
		// TODO Auto-generated method stub
		
	}
	

}
