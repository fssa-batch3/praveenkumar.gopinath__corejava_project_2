package com.fssa.savinglives.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;


public class TestUpdateRequest {

	@Test
	void testUpdateSuccess() throws ServiceException,DAOException {
		LocalDate date = LocalDate.of(2002, 2, 23);
		RequestService requestService = new RequestService(); 
		String email = "ajay12@gmail.com";
		Request request = new Request("i need B+ blood group", "Thank you for giving blood", "AB+", date,6380843016L, email);
		try {
			assertTrue(requestService.updaterequest(request, email));
		} catch (ServiceException |InvalidRequestException e) {
			e.printStackTrace();
		} 
	}
}