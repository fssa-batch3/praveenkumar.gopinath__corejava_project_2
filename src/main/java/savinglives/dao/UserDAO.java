package savinglives.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import savinglives.dao.exception.*;
import savinglives.model.User;

public class UserDAO {

	// Connect to database
//	public Connection getConnection() throws SQLException {
//
//        String url = "jdbc:mysql://localhost:3306/project";
//        Connection c = DriverManager.getConnection(url,"root", "123456");
//		return c;
//
//	}
	
	
	
	
	public Connection getConnection() throws SQLException {

		String url = "jdbc:mqsl://localhost:3306/project";
		Connection c = DriverManager.getConnection(url,"root", "123456");
		return c;
	}

	// Get user from DB - Login
	public User login(String email, String password) throws DAOException {
		try {
		User user = null;
		Connection connection = getConnection();
		String selectQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
		PreparedStatement statement = connection.prepareStatement(selectQuery);
		statement.setString(1,email);
		statement.setString(2,password);
		ResultSet rs = statement.executeQuery();
        while(rs.next()) {
        	user = new User(rs.getString("email"),rs.getString("password"));
        }
		return user;
		}catch(SQLException e) {
			throw new DAOException("Failed to Login");
		}
		
	}

	public boolean createUser(User user) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "INSERT INTO users (username, email, password)VALUES(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Failed to register User");
		}
	}

}