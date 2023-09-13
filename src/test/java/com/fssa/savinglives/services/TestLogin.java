package com.fssa.savinglives.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

class TestLoginFeature {

	@Test
	void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("praveen123@gmail.com", "Praveen", "Praveen@123");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			System.err.println(e.getMessage());

		}

	}

	@Test

	void loginSuccess() {
		UserService userService = new UserService();
//		User user1 = new User("sabin320@gmail.com", "passWord@786");
		try {

			assertEquals(2, userService.loginWithEmail("praveen123@gmail.com", "Praveen@123"));
			System.out.println("Succesfully logged in ");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}
}