package com.fssa.savinglives.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

class TestLogin {
	  
	@Test
	 void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User();
		user1.setEmail("praveenkumar1234@gmail.com");
		user1.setPassword("Duke@390");
		
		try {
			
			assertTrue(userService.loginUser(user1));
			throw new ServiceException("Login successfully. Welcome, " + user1.getEmail() + "!");
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
	}   
 
	@Test

	 void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User();
		user1.setEmail("rosh123@gmail.com");
		user1.setPassword("rosh@250");
		try {
			assertFalse(userService.loginUser(user1));
			throw new ServiceException("Login Failed. Register again");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	} 
}