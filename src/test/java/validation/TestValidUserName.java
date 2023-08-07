package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import savinglives.validation.*;
import savinglives.validation.exceptions.*;

class TestValidateUsername {
	@Test
	void testValidUsername() {
		try {
			assertTrue(UserValidator.validateName("paveen"));
		} catch (InvalidUserException e) {
			System.out.println("Hello!!! Username is valid");
		}
	}

	@Test
	void testInvalidUsernameStartingWithNumber() {
		try {
			assertFalse(UserValidator.validateName("1234Praveen"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		System.out.println("Hello!!! Username shouldn't start with number");
	}

	@Test
	void testInvalidUsernameStartingWithSpecialCharacter() {
		try {
			assertFalse(UserValidator.validateName("!#$praveen"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}

		System.out.println("Hello!!! Username shouldn't contains special character");
	}

	@Test
	void testInvalidUsernameWithSpaces() {
		try {
			assertFalse(UserValidator.validateName("prav een"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		System.out.println("Hello!!! Username shouldn't contains spaces ");
	}

	@Test
	void testInvalidUsernameToShort() {
		try {
			assertFalse(UserValidator.validateName("PRA"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		System.out.println(" Hello!!! Username shouldn't be too small ");
	}

	@Test
	public void testInvalidUsernameToLong() {
		try {
			assertFalse(UserValidator.validateName("Praveeeeeeeeeeeeeennnnnnnnkumaaaarrrr"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
		System.out.println("Hello!!! Username shouldn't be too long ");
	}
}