package com.fssa.savinglives.Request;



import java.rmi.ServerException;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.service.RequestService;
import com.fssa.savinglives.service.exception.ServiceException;

public class TestRequestModel {

	public static void main(String[] args) throws ServerException, DAOException {

		Request user1 = new Request("I need O- blood group", "Thank you for giving blood", "O-", "2023-11-23",
				"9876543211");

		RequestService requestService = new RequestService();

		try {
			requestService.create(user1);
			System.out.println("Hello User...!! Your request is created Successfully!!!");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
