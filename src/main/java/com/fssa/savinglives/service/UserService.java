package com.fssa.savinglives.service;

import java.sql.SQLException;

import com.fssa.savinglives.dao.UserDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class UserService {
	/**
	 * Registers a new user.
	 *
	 * @param user The User object containing user information.
	 * @return True if user registration is successful, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO(); 

		try {

			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
			} 
			if (userDAO.createUser(user)) {
				return true;
			} else {
				throw new ServiceException("Registration was not Successful");
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Logs in a user.
	 *
	 * @param user The User object containing user login details.
	 * @return True if login is successful, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean loginUser(User user) throws ServiceException {
		try {

			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true;
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}

	/**
	 * Updates user information.
	 *
	 * @param user The User object containing updated user information.
	 * @return True if user information is successfully updated, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean updateUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUpdateUser(user);

			if (userDAO.updateUser(user)) {
				return true;
			} else {
				throw new ServiceException("Update was not successful");

			}

		} catch (DAOException | InvalidUserException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Deletes a user.
	 *
	 * @param email The email of the user to be deleted.
	 * @return True if user is successfully deleted, otherwise false.
	 * @throws ServiceException If a service-related issue occurs.
	 */
	public boolean deleteUser(String email) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateEmail(email);
			return userDAO.deleteUser(email);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
 
	}
}