package savinglives.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import savinglives.model.User;

import savinglives.dao.exception.DAOException;

public class UserDAO {

	public static Connection getConnection() throws SQLException {
		// Connecting to DB
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/savinglives", "root", "123456");
		
	}

	// Add new user to DB - register
	public boolean create(User user) throws DAOException {
		if (user == null) {
			System.out.println("User Must not be null");
			return false;
		}

		String query = "INSERT INTO userdata (user_name, user_mail, user_pwd, mobileno) VALUES (?, ?, ?);";
		try (PreparedStatement pst = getConnection().prepareStatement(query);) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			int rows = pst.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Sql Exception while creating user ");
		}
	}

//	update user

	public boolean updateUser(User user) throws SQLException, DAOException {
		final String query = "UPDATE userdata SET user_name = ?, user_pwd = ?, WHERE user_email = ?;";

		try (PreparedStatement pst = getConnection().prepareStatement(query)) {

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			int rows = pst.executeUpdate();
			if (rows == 0) {
				throw new DAOException("User with email: " + user.getEmail() + " not found in the database.");
			}
			return (rows==1);
			
		} catch (SQLException e) {
			
			throw new DAOException("Error updating user in the database");
		}
		
	} 

	// check email is already exist
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT user_email FROM userdata WHERE user_email = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(query)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	private String userPasswordFromDb;

	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

	// login user

	public boolean loginUser(User user) throws DAOException {
		String email = user.getEmail();

		String query = "SELECT user_email,user_pwd FROM userdata WHERE user_email = ?;";
		try (PreparedStatement pst = getConnection().prepareStatement(query)) {
			pst.setString(1, email);
			try (ResultSet rs = pst.executeQuery()) {

				// User found, login successful else
				if (rs.next()) {
					String passwordfromDb = rs.getString("user_pwd");
					setUserPasswordFromDb(passwordfromDb);
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in loggin in");
		}
		return false;
	} 

}