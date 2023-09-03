package com.fssa.savinglives.Request;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class TestRequestFeature{

    @BeforeAll
    public static void setup() {
        // Initialize your test database and environment if needed
    }

    @Test
    public void testCreateRequest_Success() {
        RequestService requestService = new RequestService();
        Request validRequest = new Request("Title", "Description", "A+", "2023-09-01", "1234567890");

        try {
            assertTrue(requestService.create(validRequest));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testCreateRequest_InvalidRequest() {
        RequestService requestService = new RequestService();
        Request invalidRequest = new Request("Title", "Description", "InvalidBloodGroup", "2023-09-01", "1234567890");

        try {
            assertFalse(requestService.create(invalidRequest));
        } catch (ServiceException e) {
            assertEquals("InvalidRequestException: Blood group is not valid", e.getMessage());
        }
    }

    // Similar tests for other methods in RequestService can be added

    @Test
    public void testValidateGroup_Valid() {
        try {
            assertTrue(RequestValidator.validateGroup("A+"));
        } catch (InvalidRequestException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testValidateGroup_Invalid() {
        try {
            assertFalse(RequestValidator.validateGroup("InvalidBloodGroup"));
        } catch (InvalidRequestException e) {
            assertEquals("Blood group is not valid", e.getMessage());
        }
    }

    // Similar tests for other validation methods in RequestValidator can be added
}
