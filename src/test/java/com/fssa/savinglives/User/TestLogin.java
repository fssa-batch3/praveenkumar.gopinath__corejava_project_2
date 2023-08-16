package com.fssa.savinglives.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

class TestLogin {

	@Test
	void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User("praveen@gmail.com", "poi@2002", null);
		try {

			assertTrue(userService.loginUser(user1));
			throw new ServiceException("Login Ssuccessfully. Welcome, " + user1.getEmail() + "!");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User("praveenkumar1234@gmail.com", "kumar@3456", null);
		try {
			assertFalse(userService.loginUser(user1));
			throw new ServiceException("Login Failed.Please register again");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}