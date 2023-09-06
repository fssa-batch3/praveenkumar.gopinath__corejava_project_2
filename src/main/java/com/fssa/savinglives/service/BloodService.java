package com.fssa.savinglives.service;

import java.util.List;

import com.fssa.savinglives.validation.exceptions.InvalideBloodException;
import com.fssa.savinglives.dao.BloodDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Blood;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.BloodValidator;

public class BloodService {
	
	
	
	
	public boolean createDonor(Blood blood) throws ServiceException, DAOException {
		try {
			BloodValidator.validateBlood(blood);
		
			try {
				if (BloodDAO.create(blood)) {
					return true;
				} else {
					System.out.println("Creating failed");
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException

		} catch (InvalideBloodException e) {

			throw new ServiceException(e);
		}
		return false;

	}

	
//	public static List<Blood> getAllDonors() throws ServiceException {
//
//		try {
//
//			List<Blood> blood = BloodDAO.getAllBloods();
//			BloodValidator.validateGetAllDonors(blood);
//
//			return blood;
//
//		} catch (DAOException | InvalideBloodException e) {
//
//			throw new ServiceException(e);
//		}
//
//	}

	public boolean updateDonor(Blood blood) throws ServiceException {
		BloodDAO bloodDAO = new BloodDAO();
		try {
			BloodValidator.validateBlood(blood);
			if (bloodDAO.update(blood)) {

				return true;
			} else {
				System.err.println("Update failed");
				return false;
			}

		} catch (InvalideBloodException | DAOException e) {

			throw new ServiceException(e);
		}
	}

	
	public boolean deleteDonor(String donor) throws ServiceException {
		BloodDAO bloodDAO = new BloodDAO();
		try {
			return bloodDAO.delete(donor);

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage());															// ServiceException
		}
	}

	
	public boolean findByDonor(String donor) throws ServiceException {
		 ;
		try {
			Blood bloodDAO = BloodDAO.findByDonor(donor);

		} catch (DAOException e) {
			throw new ServiceException("Failed to retrieve product by ID", e);
		}
		return true;
	}
	

}