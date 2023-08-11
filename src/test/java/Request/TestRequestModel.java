package Request;

import java.rmi.ServerException;

import savinglives.service.RequestService;
import savinglives.service.exception.ServiceException;

import savinglives.dao.exception.DAOException;
import savinglives.model.Request;

public class TestRequestModel {

	public static void main(String[] args) throws ServerException, DAOException {

		Request user1 = new Request("i need O+ blood group", "Thank you for giving blood", "O+", "2023-08-10",
				"218965870911", "2188658708");

		RequestService requestService = new RequestService();

		try {
			requestService.create(user1);
			System.out.println("Request created successfully!");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
