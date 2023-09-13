package com.fssa.savinglives.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;


import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class TestRequestFeature {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService requestService = new RequestService();
		Request user1 = new Request("i need O+ blood group", "Thank you for giving blood", "O+", date, 9884689632L,
				"vishnu1234@gmail.com");
		try {
			requestService.create(user1);

		} catch (ServiceException | DAOException e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test
	public void testRequestFailure() throws SQLException, ServiceException, InvalidUserException {
		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService userService = new RequestService();
		Request user1 = new Request("i need AB+ blood group", "Thank you for giving blood", "AB+", date, 638084l,
				"praveen123@gmail.com");
		try {
			assertTrue(userService.create(user1));

		} catch (DAOException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testInvalidNumber() throws InvalidUserException, SQLException, ServiceException {
		LocalDate date = LocalDate.of(2002, 2, 23);

		RequestService userService = new RequestService();
		Request user1 = new Request("i need AB+ blood group", "Thank you for giving blood", "AB+", date, 638084l,
				"praveen@gmail.com");
		try {
			assertFalse(!userService.create(user1)); // Using assertTrue to check for the condition

		} catch (DAOException e) {
			e.printStackTrace();
			fail();
		}
	}

}