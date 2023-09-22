package com.fssa.savinglives.dao;

import java.sql.Connection;

/**
 * @author ArunkumarDhanraj

 *
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.utils.ConnectionUtil;

public class UserDAO {

	/**
	 * Creating Statement and inserting the user's value
	 * 
	 * @param user
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean createUser(User user) throws DAOException {

		final String QUERY = "INSERT INTO users (name,email,password) VALUES (?,?,?,?)";
		int row = 0;
		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement std = connection.prepareStatement(QUERY)) {

			std.setString(1, user.getName());
			std.setString(2, user.getEmail());
			std.setString(3, user.getPassword());

			row = std.executeUpdate();
			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in inserting the user's value", e);
		}

	}

	/**
	 * Getting the register user's details
	 * 
	 * @return List<User>
	 * @throws DAOException
	 */
	public List<User> regiteredUsersList() throws DAOException {

		ArrayList<User> users = new ArrayList<>();
		final String SELECTQUERY = "Select * from users";
		try (Connection connection =  ConnectionUtil.getConnection();
				Statement std = connection.createStatement();
				ResultSet rs = std.executeQuery(SELECTQUERY)) {

			while (rs.next()) {

				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");

				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);

				users.add(user);
			}

		} catch (SQLException e) {
			throw new DAOException("Error in resultSet", e);
		}

		return users;

	}

	/**
	 * Delete the user
	 * 
	 * @param email
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean deleteUser(String email) throws DAOException {

		final String DELETEQUERY = "DELETE FROM users where email=?";

		int row = 0;

		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement std = connection.prepareStatement(DELETEQUERY)) {

			std.setString(1, email);

			row = std.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the user", e);
		}

		return row > 0;

	}

	/**
	 * Getting the user's details by email id
	 * 
	 * @param email
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean selectByEmail(String email) throws DAOException {
		final String SELECTQUERY = "SELECT email FROM users WHERE email = ?";

		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	/**
	 * Getting the email and password for log in
	 * 
	 * @param user
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean selectForLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT email, password FROM users WHERE email = ? AND password = ?";

		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the user email and password exists
			}

		} catch (SQLException e) {
			throw new DAOException("Error in loggin in", e);
		}

	}

	/**
	 * Getting the user by email
	 * 
	 * @param email
	 * @return User
	 * @throws DAOException
	 */

	public User getUserByEmail(String email) throws DAOException {

		final String SELECTQUERY = "SELECT * FROM users WHERE email = ?";

		try (Connection connection =  ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String loggedEmail = rs.getString("email");
					String password = rs.getString("password");

					return new User(id, name, loggedEmail, password);

				}

			}

		} catch (SQLException e) {
			throw new DAOException("Cannot get user's details", e);
		}
		return null;

	}

}