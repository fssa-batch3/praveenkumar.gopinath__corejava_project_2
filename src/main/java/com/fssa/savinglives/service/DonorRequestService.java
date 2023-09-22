package com.fssa.savinglives.service;

import java.util.ArrayList;

import com.fssa.savinglives.dao.DonorRegisterDao;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.DonorValidator;
import com.fssa.savinglives.validation.exceptions.InvalideDonorRegisterException;
import com.fssa.savinglives.logger.Logger;
import com.fssa.savinglives.model.DonorRegister;

public class DonorRequestService {

	public DonorRequestService(DonorValidator donorValidator, DonorRegisterDao donorRegisterDao) {
	}

	public boolean createDonorRegister(DonorRegister donorRegister) throws ServiceException, InvalideDonorRegisterException {

		if (DonorValidator.validateDonorRequest(donorRegister)) {

			DonorRegisterDao.createDonorRegister(donorRegister);
			Logger.info("Donor request is created Successfully");
			return true;
		}
 
		return false;
	}
	// getAllDonorRequests

	public ArrayList<DonorRegister> getAllDonorRequests() throws ServiceException, InvalideDonorRegisterException {

		return DonorRegisterDao.getAllDonorDetails(); 
		
	}
	
	// method to delete donor request
	public boolean deleteDonorReg(String email) {
		return DonorRegisterDao.deleteDonorReg(email);
	}
}