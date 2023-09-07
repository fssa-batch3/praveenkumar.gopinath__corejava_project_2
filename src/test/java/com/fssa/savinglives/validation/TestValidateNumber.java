package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class TestValidateNumber {
	@Test
    void testValidatenumberValidNumber() {
        try {
            assertTrue(RequestValidator.Validatenumber("9884689632"));
            System.out.println("The request Number is valid");
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testValidatenumberInvalidNumber() {
        try {
            assertFalse(RequestValidator.Validatenumber("abcdefghij"));
            System.out.println("The request Number is invalid");
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
        }
    }
}
