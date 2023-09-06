package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class TestValidateGroup {

	@Test
	void testValidategroup() {
		try {
			assertTrue(RequestValidator.validateGroup("AB+"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testValidategroupWithAlphabetLetters() {
		try {
			assertTrue(RequestValidator.validateGroup("O-"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidategroupWithoutAlphabetLetters() {
		try {
			assertFalse(RequestValidator.validateGroup("123"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testvalidategroupWithAtPositiveSymbolOrNegativeSymbol() {
		try {
			assertTrue(RequestValidator.validateGroup("A-"));
			System.out.println("The request Blood group is validate");
		} catch (InvalidRequestException e) {
			System.out.println(e.getMessage());
			fail();
		}

	}
}
