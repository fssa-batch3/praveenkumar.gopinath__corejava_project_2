package com.fssa.savinglives.service;

import java.util.List;

import com.fssa.savinglives.dao.UserDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class UserService {

	/**
	 * Registration for users
	 * 
	 * @param user
	 * @return boolean
	 * @throws ServiceException
	 */
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		try {
			validator.validateUser(user);
			return userDAO.createUser(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Service for Login user
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		try {
			validator.validEmail(user.getEmail());
			validator.validPassword(user.getPassword());

			return userDAO.selectForLogin(user);

		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Getting the list of users
	 * 
	 * @return List<User>
	 * @throws ServiceException
	 */

	public List<User> listUsers() throws ServiceException {

		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		List<User> userList = null;
		try {
			userList = userDAO.regiteredUsersList();
			validator.validUsersList(userList);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return userList;

	}

	/**
	 * Getting the logged user's details
	 * 
	 * @param email
	 * @return User
	 * @throws ServiceException
	 */
	public User getUser(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		try {
			User loggedUser = userDAO.getUserByEmail(email);
			validator.validLoggedUser(loggedUser);
			return loggedUser;
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public boolean deleteUserByemail(String email) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.deleteUser(email);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

}