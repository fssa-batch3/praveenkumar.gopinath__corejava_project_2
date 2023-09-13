package com.fssa.savinglives.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A utility class for managing database connections.
 */
public class ConnectionUtil {
	 /*
     * This class provides a utility method for obtaining a database connection.
     * The getConnection() method retrieves connection details from environment variables or a .env file.
     * It returns a Connection object for interacting with the database.
     */
	public static Connection getConnection() {
		String dbUrl;
		String dbUser;
		String dbPassword;
		
			dbUrl = System.getenv("DB_URL");
			dbUser = System.getenv("DB_USER");
			dbPassword = System.getenv("DB_PASSWORD");
	
		// Connecting to DB  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			throw new RuntimeException("Unable to connect database",e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Database driver class not found",e);
		}
	}

	

}