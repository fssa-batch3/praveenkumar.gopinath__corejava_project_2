package savinglives.service;

import savinglives.dao.exception.DAOException;
import savinglives.dao.RequestDAO;
import savinglives.model.Request;
import savinglives.service.exception.ServiceException;
import savinglives.validation.exceptions.InvalidUserException;
import savinglives.validation.exceptions.RequestValidator;

public class RequestService {

public boolean create(Request request) throws ServiceException, DAOException {
		
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.createRequest(request)) {
				System.out.println("Successfully created");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServiceException(e);
		}

	}
	


public boolean readrequest(Request request) throws ServiceException, DAOException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.readRequest(request)) {
				System.out.println("Successfully Reading");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

public boolean updaterequest(Request request) throws ServiceException, DAOException {
	
	RequestDAO requestDAO = new RequestDAO();
		
		try {
			RequestValidator.Validation(request);
			if (requestDAO.updateRequest(request)) {
				System.out.println("Successfully Reading");
				return true;
			} else {
				return false;
			}
		} catch (InvalidUserException e) {
			throw new ServiceException(e);
		}

	}
	
}