package com.fssa.savinglives.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.service.*;
import com.fssa.savinglives.service.exception.ServiceException;

class TestLoginFeature {
	  
	@Test
	 void loginSuccess() {
		UserService userService = new UserService();

		User user1 = new User();
		user1.setEmail("gopikannan2906@gmail.com");
		user1.setPassword("Wow@2002");
		
		try {
			
			assertTrue(userService.loginUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}   
 
	@Test

	 void loginFailed() {
		UserService userService = new UserService();
		User user1 = new User();
		user1.setEmail("abcde1234@gmail.com");
		user1.setPassword("abcde@1234");
		try {
			assertFalse(userService.loginUser(user1));
			throw new ServiceException("Login Failed.Kindly Register");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	} 
}