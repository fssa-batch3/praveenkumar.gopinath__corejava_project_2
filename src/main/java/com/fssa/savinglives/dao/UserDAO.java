package com.fssa.savinglives.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.utils.ConnectionUtil;


public class UserDAO {


	/**
     * Creates a new user in the database.
     *
     * @param user The User object containing user information.
     * @return Returns true if the user creation is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean createUser(User user) throws DAOException {

		String query = "INSERT INTO userdata (user_name, user_mail, user_pwd) VALUES (?, ?, ?)";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query);) {
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			int rows = pst.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Sql Exception while creating user ");
		}
	}


	  /**
     * Updates an existing user's information in the database.
     *
     * @param user The User object containing updated user information.
     * @return Returns true if the update is successful, otherwise false.
     * @throws SQLException If there is an issue with the SQL operation.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean updateUser(User user) throws SQLException, DAOException {
		final String query = "UPDATE userdata SET user_name = ?, user_pwd = ?, mobileno = ?, WHERE user_email = ?;";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(7, user.getEmail());
			int rows = pst.executeUpdate();
			if (rows == 0) {
				throw new DAOException("User with email: " + user.getEmail() + " not found in the database.");
			}
			return (rows == 1);

		} catch (SQLException e) {

			throw new DAOException("Error updating user in the database");
		}

	}



	 /**
     * Deletes a user from the database based on their email.
     *
     * @param email The email of the user to be deleted.
     * @return Returns true if the deletion is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean deleteUser(String email) throws DAOException {
		String deleteQuery = "DELETE FROM userdata where user_mail=?";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {

			ps.setString(1, email);
			int rows = ps.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException("Error in delete user ", e);
		}

	}

	 /**
     * Checks if an email is already registered in the system.
     *
     * @param email The email to be checked.
     * @return Returns true if the email is already registered, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT user_mail FROM userdata WHERE user_mail = ?";

		try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	private String userPasswordFromDb;

	 /**
     * Gets the user's password from the database.
     *
     * @return The user's password from the database.
     */
	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	/**
     * Sets the user's password in the database.
     *
     * @param userPasswordFromDb The user's password to be set in the database.
     */
	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}
	 /**
     * Tries to log in a user by checking their credentials in the database.
     *
     * @param user The user's login details.
     * @return Returns true if the login is successful, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
	public boolean loginUser(User user) throws DAOException {
		String email = user.getEmail();

		String query = "SELECT user_email,user_pwd FROM userdata WHERE user_email = ?;";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
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
			throw new DAOException("Error in login");
		}
		return false;
	}

}