package user;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import savinglives.model.*;

import savinglives.service.*;
import savinglives.service.exception.ServiceException;

 class TestRegisterFeature {
	@Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("soffan2906@gmail.com", "Soffan", "Wow@2002");

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
		User user1 = new User("soffafuywg892698gmail.com", "Soffan", "Wow@2002");

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	 void testUserNull() {

		UserService userservice = new UserService();
		User user1 = null;

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}