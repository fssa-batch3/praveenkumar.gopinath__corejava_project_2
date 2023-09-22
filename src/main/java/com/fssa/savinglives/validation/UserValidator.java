package com.fssa.savinglives.validation;

import java.util.List;

/**
 * @author Praveenkumar.G
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.savinglives.dao.UserDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class UserValidator {

	/**
	 * Validating all the attributes
	 * 
	 * @param user
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validateUser(User user) throws InvalidUserException {

		return validName(user.getName()) && validPassword(user.getPassword())
				&& validEmail(user.getEmail()) && isEmailExists(user.getEmail());

	}

	/**
	 * validating username
	 * 
	 * @param name
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validName(String name) throws InvalidUserException {

		String regex = "^[a-zA-Z]{3,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);

		if (matcher.matches() && name != null)
			return true;

		throw new InvalidUserException("Invalid Username: Username Should be greater than 3 letters and without special characters");

	}

	
	/**
	 * validating password
	 * 
	 * @param password
	 * @return
	 * @throws InvalidUserException
	 */
	public boolean validPassword(String password) throws InvalidUserException {

		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches() && password != null)
			return true;
		else
			throw new InvalidUserException(
					"Password must contain atleast 1 CAPITAL LETTER, small letter, special characters and numbers");

	}

	/**
	 * validating email
	 * 
	 * @param email
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validEmail(String email) throws InvalidUserException {

		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() && email != null)
			return true;

		throw new InvalidUserException("Invalid email");

	}

	/**
	 * Checking whether the email already exists
	 * 
	 * @param email
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean isEmailExists(String email) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

		try {
			if (userDAO.selectByEmail(email))
				throw new InvalidUserException("Email is already registered");

			return true;
		} catch (DAOException e) {
			throw new InvalidUserException("Error in selecting by email");
		}

	}

	/**
	 * Validating the user's list
	 * @param userList
	 * @throws InvalidUserException
	 */
	public void validUsersList(List<User> userList) throws InvalidUserException {

		if (userList == null || userList.isEmpty())
			throw new InvalidUserException("Noone registered");

	}

	/**
	 * validating the logged user's details
	 * @param user
	 * @throws InvalidUserException
	 */
	public void validLoggedUser(User user) throws InvalidUserException {

		if (user == null)
			throw new InvalidUserException("Cannot get user's details");

	}

}