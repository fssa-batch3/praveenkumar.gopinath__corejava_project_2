package com.fssa.savinglives.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.validation.exceptions.InvalidUserException;

class TestValidateEmail {

    @Test
    void testValidEmail() {
        try {
            assertTrue(UserValidator.validateEmail("praveenkumar1234@gmail.com"));
            System.out.println("Valid email");
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidEmailWithoutAtSymbol() {
        try {
            assertFalse(UserValidator.validateEmail("praveenkumar1234gmail.com"));
            System.out.println("Invalid email: Missing '@' symbol");
        } catch (InvalidUserException e) {
            System.out.println("Valid email");
        }
    }
 
    @Test
    void testInvalidEmailWithoutcom() {
        try {
            assertFalse(UserValidator.validateEmail("praveenkumar@"));
            System.out.println("Invalid email: Missing domain");
        } catch (InvalidUserException e) {
            System.out.println("Valid email");
        }
    }
}