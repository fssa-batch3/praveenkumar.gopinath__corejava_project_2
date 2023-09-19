package com.fssa.savinglives.service;

import java.util.List;

import com.fssa.savinglives.dao.UserDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class UserService {
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
				System.err.println("Registered failed");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	public boolean loginUser(User user) throws ServiceException {
		try {

			UserValidator.validLoginCredentials(user);

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true;
			} else {

				throw new ServiceException("Check Your Email And Password that you entered while you registered");
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	public boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateEmail(user.getEmail());
			return userDAO.update(user);

		} catch (InvalidUserException | DAOException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	public boolean deleteUser(int userId) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			// Check if the user deletion in the DAO was successful and provide feedback
			return userDAO.deleteUser(userId);

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}

	}

	public User findingUserByEmail(String email) throws ServiceException {
		try {
			// Call the DAO method to retrieve the user by email

			User user = new UserDAO().findUserByEmail(email);

			if (user == null)
				throw new ServiceException("user obj is null");

			return user;
		} catch (DAOException e) {
			// You can handle or throw the exception as needed
			throw new ServiceException("Error dao in service", e);
		}
	}

	public static List<User> getAllUser() throws ServiceException {

		UserDAO userDAO = new UserDAO();// Create an instance of ProductDAO
		try {

			List<User> user = userDAO.allUser();
			UserValidator.validateGetAllUser(user);

			return user;

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}

	}

}