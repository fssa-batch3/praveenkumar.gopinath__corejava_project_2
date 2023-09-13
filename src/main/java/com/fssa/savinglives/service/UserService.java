package com.fssa.savinglives.service;

import java.sql.SQLException;

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
				throw new ServiceException("Registration was not Successful");
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
			}
			else {
				
				throw new ServiceException("Check Your Email And Password that you entered while you registered");
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}


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

	
	public boolean deleteUser(String email) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.deleteUser(email);
		} catch (DAOException  e) {
			throw new ServiceException(e.getMessage());
		}
 
	}
}