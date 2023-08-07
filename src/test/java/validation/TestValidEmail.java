package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import savinglives.validation.*;
import savinglives.validation.exceptions.*;


class TestValidEmail {

	@Test
	void testValidEmail() {
		try {

			assertTrue(UserValidator.validateEmail("praveen007@gmail.com"));
			System.out.println("Your email is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("kumar1234gmail.com"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidEmailWithoutcom() {
		try {

			assertFalse(UserValidator.validateEmail("praveen46@"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}
