package com.fssa.savinglives.RequestValidation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class TestValidategroup {

	@Test
	void testValidategroup() {
		try {
			assertTrue(RequestValidator.Validategroup("AB+"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testValidategroupWithAlphabetLetters() {
		try {
			assertTrue(RequestValidator.Validategroup("O-"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidategroupWithoutAlphabetLetters() {
		try {
			assertFalse(RequestValidator.Validategroup("123"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testvalidategroupWithAtPositiveSymbolOrNegativeSymbol() {
		try {
			assertTrue(RequestValidator.Validategroup("A-"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}

	}
}
