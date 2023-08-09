package savinglives.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import savinglives.model.User;
import savinglives.validation.exceptions.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {
		// User is valid if username is valid and email is valid and password is valid

		if (user != null && validateName(user.getUsername()) && validateEmail(user.getEmail())
				&& validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		try {
			String regex = "^[A-Za-z]\\w{3,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The user name is valid.");
			} else {

				throw new InvalidUserException("The user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		try {
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
			if (match) {
				System.out.println("Valid password.");
			} else {

				throw new InvalidUserException("Invalid password.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null) {
			return false;
		}
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email is Valid");
			} else {
				throw new InvalidUserException("The email is not valid");
			}
			return isMatch;
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return isMatch;
	}
}