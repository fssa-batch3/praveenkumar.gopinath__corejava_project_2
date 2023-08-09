package validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import savinglives.validation.UserValidator;
import savinglives.validation.exceptions.InvalidUserException;

 class TestValidatePassword {
@Test
 void TestValidPassword() {
	try {
		
		assertTrue(UserValidator.validatePassword("Poi@4693"));
		System.out.println("The password is valid");
	} catch (InvalidUserException e) {
		System.out.println(e.getMessage());
	}
	
	
}
@Test
 void TestInValidPassword() {
	try {
		
		assertFalse(UserValidator.validatePassword("Poi4693"));
		System.out.println("The password is not valid");
	} catch (InvalidUserException e) {
		
		System.out.println(e.getMessage());
	}
}

@Test
 void TestInValidPasswordWithoutNumbers() {
	try {
		
		assertFalse(UserValidator.validatePassword("Poi@"));
		System.out.println("The password is without numbers");
	} catch (InvalidUserException e) {
		
		System.out.println(e.getMessage());
	}
}
@Test
 void TestInValidPasswordWithoutCapitalLetters() {
	try {
		
		assertFalse(UserValidator.validatePassword("poi@4693"));
		System.out.println("The password is without Capital letters");
	} catch (InvalidUserException e) {
	
		System.out.println(e.getMessage());
	}
}
@Test
 void TestInValidPasswordWithoutSmallLetters() {
	try {
		
		assertFalse(UserValidator.validatePassword("POI@4693"));
		System.out.println("The password is without small letters");
	} catch (InvalidUserException e) {
		
		System.out.println(e.getMessage());
	}
}
@Test
 void TestInValidPasswordShorterLength() {
	try {
		
		assertFalse(UserValidator.validatePassword("P@4693"));
		System.out.println("The password too short");
	} catch (InvalidUserException e) {
		System.out.println(e.getMessage());
	}
}

}