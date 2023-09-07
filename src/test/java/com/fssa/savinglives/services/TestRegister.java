package com.fssa.savinglives.services;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

class TestRegister {
	@Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User();
		user1.setEmail("vishnu460323@gmail.com");
		user1.setName("Vishnu");
		user1.setPassword("Vishnu@1234");
		try {
			assertTrue(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e);
		}
   
	}

	@Test
	 void testRegistrationFail() {

		UserService userservice = new UserService();
		User user1 = new User();
		user1.setEmail(null);
		user1.setName(null);
		user1.setPassword(null);
		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	 void testUserEmpty() {

		UserService userservice = new UserService();
		User user1 = null;

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}