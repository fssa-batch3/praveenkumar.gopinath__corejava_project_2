package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class TestValidateDate {

	@Test
	void testValidatedateValidDate() {
		try {
			assertTrue(RequestValidator.validateDate("2023-08-15"));
			System.out.println("The request Date is valid");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testValidatedateInvalidDate() {
		try {
			assertFalse(RequestValidator.validateDate("2023/08/15"));
			System.out.println("The request Date is invalid");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
		}
	}

}
