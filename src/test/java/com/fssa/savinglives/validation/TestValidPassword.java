package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.UserValidator;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

class TestValidatePassword {
	@Test
	void testValidPassword() {
		try {

			assertTrue(UserValidator.validatePassword("Duke@390"));
			System.out.println("The password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			
		}

	}

	@Test
	void testInValidPassword() {
		try {

			assertFalse(UserValidator.validatePassword("Duke390"));
			System.out.println("The password is not valid");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		
		}
	}

	@Test
	void testInValidPasswordWithoutNumbers() {
		try {

			assertFalse(UserValidator.validatePassword("Duke@"));
			System.out.println("The password is without numbers");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
			
		}
	}

	@Test
	void testInValidPasswordWithoutCapitalLetters() {
		try {

			assertFalse(UserValidator.validatePassword("duke@390"));
			System.out.println("The password is without Capital letters");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
			
		}
	}

	@Test
	void testInValidPasswordWithoutSmallLetters() {
		try {

			assertFalse(UserValidator.validatePassword("DUKE@390"));
			System.out.println("The password is without small letters");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
			
		}
	}

	@Test
	void testInValidPasswordShorterLength() {
		try {

			assertFalse(UserValidator.validatePassword("P@2002"));
			System.out.println("The password too short");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			
		}
	}

}