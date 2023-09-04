package com.fssa.savinglives.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.savinglives.model.User;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;


public class UserValidator {
	
//	private Constructor
	
	
	public static boolean validateUser(User user) throws InvalidUserException {

//		User is Valid if user name is valid and email is valid and pwd is valid
		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getName()) || !validateEmail(user.getEmail()) || !validatePassword(user.getPassword())) {
			throw new InvalidUserException("User details not valid");
		}

		return true;

	}

	/**
	 * Validates user details for update.
	 *
	 * @param user The user to be validated.
	 * @return true if user details are valid.
	 * @throws InvalidUserException If user details are not valid.
	 */
	public static boolean validateUpdateUser(User user) throws InvalidUserException {

//		User is Valid if user name is valid and email is valid and pwd is valid
		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getName()) || !validateEmail(user.getEmail()) || !validatePassword(user.getPassword())) {
			throw new InvalidUserException("User details not valid");
		}

		return true;

	}

	/**
	 * Validates the user's name.
	 *
	 * @param name The name to be validated.
	 * @return true if the name is valid.
	 * @throws InvalidUserException If the name is not valid.
	 */
	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;

		if (name == null || name.trim().isEmpty()) {
			return false;
		}

		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("The user name is not valid");

		}

	}

	/**
	 * Validates the user's password.
	 *
	 * @param password The password to be validated.
	 * @return true if the password is valid.
	 * @throws InvalidUserException If the password is not valid.
	 */
	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;

		if (password == null || password.trim().isEmpty()) {
			return false;
		}

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid password.");

		}

	}

	/**
	 * Validates the user's email address.
	 *
	 * @param email The email address to be validated.
	 * @return true if the email address is valid.
	 * @throws InvalidUserException If the email address is not valid.
	 */
	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;

		if (email == null || email.trim().isEmpty()) {
			return false;
		}

		 String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The email address is: Invalid");

		}

	} 
}