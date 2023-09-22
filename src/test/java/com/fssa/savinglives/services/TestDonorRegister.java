package com.fssa.savinglives.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.savinglives.dao.DonorRegisterDao;
import com.fssa.savinglives.enums.DonorBloodGroup;
import com.fssa.savinglives.enums.DonorDistrict;
import com.fssa.savinglives.enums.DonorGender;
import com.fssa.savinglives.enums.DonorState;
import com.fssa.savinglives.logger.Logger;
import com.fssa.savinglives.model.DonorRegister;
import com.fssa.savinglives.service.DonorRequestService;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.DonorValidator;
import com.fssa.savinglives.validation.exceptions.InvalideDonorRegisterException;

public class TestDonorRegister {
	Logger logger = new Logger();

	DonorRequestService rs = new DonorRequestService(new DonorValidator(), new DonorRegisterDao());

	DonorRegister donorRegister = new DonorRegister("aravind@gmail.com", "Aravind", 21, DonorGender.MALE, DonorBloodGroup.A_NEGATIVE, "#211, pannamarathotti 4th street", DonorState.TAMIL_NADU, DonorDistrict.CHENNAI, "9941568557");

	@Test
	void createDonorRegTest() {
		assertDoesNotThrow(() -> rs.createDonorRegister(donorRegister));

	}

	@Test
	void getAllDonorRequests() throws ServiceException, InvalideDonorRegisterException {
		ArrayList<DonorRegister> ar = rs.getAllDonorRequests();
		Logger.info(ar);

		// it fails.
		if (ar != null) {
			assertTrue(true);
		} else {
			Assertions.fail();
		}
	}

	@Test
	void deleteDonorReg() {
		assertFalse(rs.deleteDonorReg("aravind@gmail.com.com"));
	}
}