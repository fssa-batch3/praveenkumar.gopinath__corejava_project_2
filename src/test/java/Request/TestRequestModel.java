package Request;



import savinglives.service.RequestService;
import savinglives.service.exception.ServiceException;

import java.rmi.ServerException;

import savinglives.dao.exception.DAOException;
import savinglives.model.Request;

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
