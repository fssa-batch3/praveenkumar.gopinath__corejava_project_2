package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

class TestValidUsername {
	@Test
	 void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("Praveen"));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	} 
 
	@Test
	 void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("46Praveen"));

		} catch (InvalidUserException e) {
			System.out.println("username should not start with number");

		}
	}

	@Test
	 void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("#$@prav!"));
			System.out.println("username should not contains special character");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("p r a v"));
			System.out.println("username should not contains spaces ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooShort() {
		try {

			assertFalse(UserValidator.validateName("Pr"));
			System.out.println("username should not be too small ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		} 
	}

	@Test
	 void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Praaaaavvvvvveeeeeeeennnnnnnn"));
			System.out.println("username should not be too long ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}