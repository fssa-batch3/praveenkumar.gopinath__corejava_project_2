package com.fssa.savinglives.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.utils.ConnectionUtil;

public class UserDAO {

	public boolean createUser(User user) throws DAOException {

		String query = "INSERT INTO user (user_name, user_email, user_pwd,) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			int rows = pst.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Sql Exception while creating the user ");
		}
	}
	
	

	public boolean updateUser(User user) throws SQLException, DAOException {
		final String query = "UPDATE user SET user_name = ?, user_pwd = ?, WHERE user_email = ?;";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			int rows = pst.executeUpdate();
			if (rows == 0) {
				throw new DAOException("User with email: " + user.getEmail() + " not found in the database.");
			}
			return (rows == 1);

		} catch (SQLException e) {

			throw new DAOException("Error updating user in the database");
		}

	}

	public boolean deleteUser(String email) throws DAOException {
		String deleteQuery = "DELETE FROM user where email=?";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {

			ps.setString(1, email);
			int rows = ps.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Error in delete user ", e);
		}

	}

	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT user_email FROM userdata WHERE user_email = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
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
	
	public boolean loginUser(User user) throws DAOException {
		String email = user.getEmail();

		String query = "SELECT user_email,user_pwd FROM userdata WHERE user_mail = ?;";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query)) {
			pst.setString(1, email);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					String passwordfromDb = rs.getString("user_pwd");
					setUserPasswordFromDb(passwordfromDb);
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error in login");
		}
		return false;
	}

}