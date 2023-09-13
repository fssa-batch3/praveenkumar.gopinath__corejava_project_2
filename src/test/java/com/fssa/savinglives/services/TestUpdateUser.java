package com.fssa.savinglives.services;

import com.fssa.savinglives.model.User;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.fssa.savinglives.service.UserService;
import com.fssa.savinglives.service.exception.ServiceException;

class TestUpdateUserFeature {

//	Success test case for update
	@Test 
	void testUpdateSuccess() {

		UserService userservice = new UserService();

		User user1 = new User("gopikannan2906@gmail.com", "Praveenkumar", "Prave@1234");
		try {
			assertTrue(userservice.updateUser(user1));
		} catch (ServiceException e) {
			
			System.out.println(e.getMessage());

		}

	} 
	
//	Fail test case for update  

	@Test
	void testUpdateFail() {

		UserService userservice = new UserService();

		User user1 = new User("praveen@1234", "Praveenkumar", "Prave@1234");
		try {
			assertFalse(userservice.updateUser(user1));
		} catch (ServiceException e) {
			
			System.out.println(e);

		}

	}

}