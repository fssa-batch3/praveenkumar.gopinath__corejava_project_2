package com.fssa.savinglives.services;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import com.fssa.savinglives.dao.BloodRequestDAO;
import com.fssa.savinglives.enums.*;
import com.fssa.savinglives.model.BloodRequest;
import com.fssa.savinglives.service.BloodRequestService;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.BloodReqValidator;

class TestRequestFeature {

	BloodRequestService newRequest = new BloodRequestService(new BloodReqValidator(), new BloodRequestDAO());

	BloodRequest createRequest = new BloodRequest("Roshan", "675 Main Street, Apt. 10C", "A+", "2 units for surgery",
			BloodGroup.A_POSITIVE, LocalDate.parse("2023-08-20"), "9025839189", true);

	@Test
	void createBloodReqTest() {
		try {
			assertTrue(newRequest.createBloodReq(createRequest));
			System.out.println("Your Request successfully created");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}
}
