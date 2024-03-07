package com.bookcart.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
	
	private static Connection connection;
	public static Connection getConnect()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookcart","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
