package com.fssa.savinglives.service;

import java.util.List;

import com.fssa.savinglives.dao.RequestDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class RequestService {

	public boolean registerRequest(Request request) throws ServiceException {

		RequestDAO requestDAO = new RequestDAO();
		try {
			RequestValidator.validationRequest(request);
			if (requestDAO.createRequest(request)) {
				System.out.println("Successfully created");
				return true;
			} else {
				System.out.println("Request is not Successfully created");
				return false;
			}
		} catch (DAOException | InvalidRequestException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public static boolean readRequest(Request request) throws ServiceException {

		RequestDAO requestDAO = new RequestDAO();

		try {
			RequestValidator.validationRequest(request);
			if (requestDAO.createRequest(request)) {
				System.out.println("Successfully Reading");
				return false;
			} else {
				System.out.println("Request is not successfully read");
				return false;
			}
		} catch (DAOException | InvalidRequestException e) {
			throw new ServiceException(e);
		}
	}

	public boolean updateRequest(Request request) throws ServiceException, DAOException {

		RequestDAO requestDAO = new RequestDAO();

		try {
			RequestValidator.validationRequest(request);
			if (requestDAO.updateRequest(request)) {
				System.out.println("Successfully Reading");
				return true;
			} else {
				System.out.println("request is not successfully update");
				return false;
			}
		} catch (DAOException | InvalidRequestException e) {
			throw new ServiceException(e);
		}

	}

	public static List<Request> getRequestsByBloodGroup(String bloodGroup) throws ServiceException {
		List<Request> requestList = null;
		RequestDAO requestDAO = new RequestDAO();

		try {
			List<Request> requestList1 = requestDAO.getRequestsByBloodGroup(bloodGroup);
			RequestValidator.validateGetAllRequests(requestList1);

			System.out.println("Successfully got the requests.");
			return requestList1;

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error in data access", e);
		} catch (InvalidRequestException e) {
			e.printStackTrace();
			throw new ServiceException("Invalid request", e);
		}
	}

}
