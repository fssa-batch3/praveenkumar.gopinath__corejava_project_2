package savinglives.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import savinglives.model.User;
import savinglives.validation.exceptions.InvalidUserException;


public class UserValidator {

	/**
     * Validates a user object.
     * A valid user must have a valid username, a valid email, and a valid password.
     *
     * @param user The user object to validate.
     * @return true if the user is valid, false otherwise.
     * @throws InvalidUserException If the user details are not valid.
     */
    public static boolean validateUser(User user) throws InvalidUserException {
        if (user == null) {
            throw new InvalidUserException("User object is Invalid!");
        }

        boolean isValidUsername = validateName(user.getUsername());
        boolean isValidEmail = validateEmail(user.getEmail());
        boolean isValidPassword = validatePassword(user.getPassword());

        if (isValidUsername && isValidEmail && isValidPassword) {
            return true;
        } else {
            throw new InvalidUserException("User details are not valid.");
        }
    }
	    public static boolean validateName(String username) {
	        if (username == null) {
	            System.out.println("Username is null. Invalid!");
	            return false;
	        }
	        String regex = "^[A-Za-z]\\w{2,29}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(username);
	        boolean isValid = matcher.matches();
	        if (isValid) {
	            System.out.println("The username is valid.");
	        } else {
	            System.out.println("The username is not valid.");
	        }

	        return isValid;
	    }
	
	
	// Password Validation	
	    public static boolean validatePassword(String password) {
	        if (password == null) {
	            System.out.println("Password is null. Invalid!");
	            return false;
	        }
	        String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
	        Pattern regex = Pattern.compile(pattern);
	        Matcher matcher = regex.matcher(password);
	        boolean isValid = matcher.matches();
	        if (isValid) {
	            System.out.println("The password is valid.");
	        } else {
	            System.out.println("The password is not valid.");
	        }

	        return isValid;
	    }
	
	// Email Validation
	    //Email validation
	    public static boolean validateEmail(String email) {
	        if (email == null) {
	            System.out.println("Email is Invalid!");
	            return false;
	        }
	        String regex = "^.*@.*\\..*$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        boolean isValid = matcher.matches();
	        if (isValid) {
	            System.out.println("The email is valid.");
	        } else {
	            System.out.println("The email is invalid.");
	        }
	        return isValid;
	    }
	   
}
