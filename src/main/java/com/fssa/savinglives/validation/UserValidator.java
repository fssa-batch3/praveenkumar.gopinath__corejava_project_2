package com.fssa.savinglives.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.savinglives.model.User;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class UserValidator {

	public static boolean validateUserId(int id) throws InvalidUserException {
		if (id > 0)
			return true;
		else
			throw new InvalidUserException("Invalid User Id");
	}

	public static boolean validateUser(User user) throws InvalidUserException {

		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getUsername()) || !validateEmail(user.getEmail())
				|| !validatePassword(user.getPassword())) {
			throw new InvalidUserException("User details not valid");
		}
		return true;

	}

	public static boolean validateUpdateUser(User user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("User details cannot be null");
		}

		if (!validateName(user.getUsername()) || !validateEmail(user.getEmail())
				|| !validatePassword(user.getPassword())) {
			throw new InvalidUserException("User details not valid");
		}
		return true;

	}

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
			throw new InvalidUserException(
					"User email is invalid: Enter your email like this ex:abcdefgh123@gmail.com");

		}

	}

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
			throw new InvalidUserException("User name is invalid: Enter your name like this ex:Abcdefgh");

		}

	}

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
			throw new InvalidUserException("User password is invalid: Enter your password like this ex:Abc@1234");

		}

	}

	public static boolean validLoginCredentials(User user) throws InvalidUserException {

		if (!validateEmail(user.getEmail())) {
			throw new InvalidUserException(
					"User email is invalid: Enter your email like this ex: abcdefgh123@gmail.com");
		}
		if (!validatePassword(user.getPassword())) {
			throw new InvalidUserException("User password is invalid: Enter your password like this ex:Abc@123");
		}
		return true;

	}

	public static void validateGetAllUser(List<User> user) throws InvalidUserException {

		if (user == null || user.isEmpty())
			throw new InvalidUserException("There is no product");

	}

}