package com.fssa.savinglives.UserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class TestValidUserName {
	@Test
	public void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("Praveen"));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("1Praveen"));

		} catch (InvalidUserException e) {
			System.out.println("username should not start with number");

		}
	}

	@Test
	public void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("#praveen"));
			System.out.println("username should not contains special character");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("Praveen kumar"));
			System.out.println("username should not contains spaces ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameToShort() {
		try {

			assertFalse(UserValidator.validateName("Pra"));
			System.out.println("username should not be to small ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Pravvvvveeeeeeeeeeeeeeennnnnnnn"));
			System.out.println("username should not be to long ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}