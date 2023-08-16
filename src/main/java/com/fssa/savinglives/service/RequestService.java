package com.fssa.savinglives.service;

import com.fssa.savinglives.dao.RequestDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.exception.ServiceException;
import com.fssa.savinglives.validation.RequestValidator;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class RequestService {

	public boolean create(Request request) throws ServiceException {

		RequestDAO requestDAO = new RequestDAO();
		try {
			RequestValidator.Validation(request);
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

	public boolean readRequest(Request request) throws ServiceException {

		RequestDAO requestDAO = new RequestDAO();

		try {
			RequestValidator.Validation(request);
			if (requestDAO.createRequest(request)) {
				System.out.println("Successfully Reading");
				return true;
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
			RequestValidator.Validation(request);
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

}