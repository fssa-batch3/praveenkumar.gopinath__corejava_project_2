package com.fssa.savinglives.service;

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
			if (userDAO.create(user)) {
				System.out.println(user.getUsername() + " Successfully Register");
				return true;
			} else {
				System.out.println("Registration was not Successful");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

//	Login service logic code

	public boolean loginUser(User user) throws ServiceException {
		boolean isMatch = false;

		try {

			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDatabase().equals(user.getPassword()))) {
				return true;
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
		return isMatch;
	}

}