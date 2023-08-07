package savinglives.service;

import savinglives.dao.UserDAO;
import savinglives.dao.exception.DAOException;
import savinglives.model.User;
import savinglives.service.exception.ServiceException;
import savinglives.validation.UserValidator;
import savinglives.validation.exceptions.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
			}
			if (userDAO.register(user)) {
				System.out.println(user.getUsername() + "  Succesfully registered");
				return true;
			} else {
				System.out.println("Registration failed");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}

	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

	}
//
//	public static void main(String[] args) throws ServiceException {
//		UserService reg = new UserService();
//
//		User user2 = new User("praveengmail.com", "passWord@786");
//
//		reg.loginUser(user2);
//	}

}