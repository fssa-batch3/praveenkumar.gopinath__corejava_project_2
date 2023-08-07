package user;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import savinglives.dao.UserDAO;
import savinglives.dao.exception.DAOException;
import savinglives.model.User;
import savinglives.service.UserService;
import savinglives.service.exception.ServiceException;

class TestRegister{

	@Test
	void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("praveen@gmail.com", "praveen", "passWord@786");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.printf("  Registered failed", e);

		}

	}

	@Test
	 void testRegistrationFail() {
		UserService userService = new UserService();

		User invalidUser = new User("pra@gmail.com","Je", "rd23");

		try {

			assertFalse(userService.registerUser(invalidUser));
			System.out.println("please fill your input");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testUserNull() {
		UserService userservice = new UserService();
		User user1 = null;
		try {
			assertFalse(userservice.registerUser(user1));
			System.out.println("Can not be null");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}

	}

//	@AfterAll
//	static void deleteByEmail() {
//		UserDAO dao = new UserDAO();
//
//		try {
//			dao.deleteUser("sabin321@gmail.com");
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
//
//	}

}