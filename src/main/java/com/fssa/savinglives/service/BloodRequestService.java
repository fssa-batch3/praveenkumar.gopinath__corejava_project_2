package com.fssa.savinglives.service;

import java.util.ArrayList;

import com.fssa.savinglives.model.BloodRequest;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.BloodReqValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;
import com.fssa.savinglives.dao.exception.DAOException;

import com.fssa.savinglives.dao.BloodRequestDAO;

public class BloodRequestService {
	public BloodRequestService(BloodReqValidator bloodReqValidator, BloodRequestDAO bloodRequestDAO) {
	}

	public boolean createBloodReq(BloodRequest createRequest) throws ServiceException {
		BloodRequestDAO requestDAO = new BloodRequestDAO();
		try {
			BloodReqValidator.validateBloodRequest(createRequest);
			if (requestDAO.createBloodReq(createRequest)) {
				return true;
			} else {
				System.err.println("Creating the blood request is failed");
				return false;
			}

		} catch (InvalidRequestException | DAOException e) {

			throw new ServiceException(e);
		}

	}

	public boolean updateProduct(BloodRequest bloodReqUpdate) throws ServiceException {
		BloodRequestDAO requestDAO = new BloodRequestDAO();
		try {
			BloodReqValidator.validateBloodRequest(bloodReqUpdate);
			if (requestDAO.updateBloodReq(bloodReqUpdate)) {

				return true;
			} else {
				System.err.println("Update failed");
				return false;
			}

		} catch (InvalidRequestException | DAOException e) {

			throw new ServiceException(e);
		}
		
	}
	public ArrayList<BloodRequest> getAllBloodRequest() throws DAOException {

		return BloodRequestDAO.getAllBloodRequest();


	}

}