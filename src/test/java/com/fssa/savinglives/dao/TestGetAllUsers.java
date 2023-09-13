package com.fssa.savinglives.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.savinglives.dao.UserDAO;
import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.service.UserService;
import com.fssa.savinglives.service.exception.ServiceException;

class TestGetAllUsers {
	@Test
	void ValidGetSuccess() {

		try {

			List<User> list = UserService.getAllUser();
			assertNotNull(list);

			System.err.println(list.toString());

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

}