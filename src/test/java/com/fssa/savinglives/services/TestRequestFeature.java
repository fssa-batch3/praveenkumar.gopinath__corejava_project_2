package com.fssa.savinglives.services;

import static org.junit.Assert.*;
import org.junit.Test;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;

import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class TestRequestFeature{ 

		public static void main(String[] args) throws DAOException {
			
			Request request = new Request("i need 	O- blood group", "Thank you for giving blood", "O-", "2023-08-07", "9884689632");
			RequestService requestService = new RequestService();

			try {
				requestService.registerRequest(request);
			} catch (ServiceException e) {
				e.printStackTrace();
				fail();
			}

		}
	
		@Test
		public void testRequestSuccess() throws DAOException, ServiceException, InvalidUserException {

			RequestService requestService = new RequestService();
			Request request = new Request("I need O- blood group", "Thank you for giving blood", "O-", "2023-08-07", "9884689632");
			try {
				assertTrue(requestService.registerRequest(request));
			
			} catch (ServiceException e) {
				
				e.printStackTrace();
				fail();
			}
		
		}
		
    // Similar tests for other validation methods in RequestValidator can be added
}

