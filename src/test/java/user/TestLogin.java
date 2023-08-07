package user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import savinglives.model.User;
import savinglives.service.UserService;
import savinglives.service.exception.ServiceException;

class TestLoginFeature {

	@Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("praveen@gmail.com", "praveen", "passWord@786");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			System.out.println("Registered failed");

		}

	}

	@Test

	 void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("praveen@gmail.com", "praveen", "passWord@786");
		try {

			assertTrue(userService.loginUser(user1));
			System.out.println("Succesfully logged in " + user1.getUsername());
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test

	 void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("praveen@gmail.com", "Password@796", "praveen");
		try {

			assertFalse(userService.loginUser(user2));
			System.out.println("please check your details");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}