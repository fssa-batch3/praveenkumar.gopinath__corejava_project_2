package com.fssa.savinglives.UserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class TestValidEmail {
	@Test
	void testValidEmail() {

		try {

			assertTrue(UserValidator.validateEmail("praveen4693@gmail.com"));
			System.out.println("Your email is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("praveen4693gmail.com"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println("Your email is valid");
		}
	}

	@Test
	void testInvalidEmailWithoutcom() {
		try {
			assertFalse(UserValidator.validateEmail("praveen4693@"));
			System.out.println("Your email is not valid");

		} catch (InvalidUserException e) {
			System.out.println("Your email is valid");
		}
	}

}