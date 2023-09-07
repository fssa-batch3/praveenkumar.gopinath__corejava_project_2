package com.fssa.savinglives.services;

import static org.junit.Assert.fail;

import java.util.List;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;

public class TestRequestListFeature {

	public static void main(String[] args) throws DAOException {
		
//		Request request = new Request("i need 	O- blood group", "Thank you for giving blood", "O-", "2023-08-06", "9884689632");
		RequestService requestService = new RequestService();

		try {
			String bloodGroup = "O+";
			List<Request> requests = RequestService.getRequestsByBloodGroup(bloodGroup);
			for(Request request : requests) {
				System.out.println(request.gettitle() + " | " +request.getdesc()+ " | " + request.getbloodgroup()+ " | " +request.getdate()+ " | " + request.getnumber());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}
}
