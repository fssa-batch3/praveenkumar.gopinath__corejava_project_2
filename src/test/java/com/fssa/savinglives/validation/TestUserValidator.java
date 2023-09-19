package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.savinglives.model.User;

import com.fssa.savinglives.validation.exceptions.InvalidUserException;

class TestUserValidator {
	@Test
	void testValidUser() throws InvalidUserException {
		User user1 = new User("praveenkumar1234@gmail.com", "Praveenkumar", "Duke@390");
		try {
			assertTrue(UserValidator.validateUpdateUser(user1));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	@Test
	void testInvalidUser() {
		User user1 = new User("000.com", "000", "0");
	  
		try {
			assertFalse(UserValidator.validateUpdateUser(user1));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println("Enter your name like this ex:Abcdefgh");
		}
	}

	
}
