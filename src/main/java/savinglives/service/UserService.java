package savinglives.service;

import java.sql.SQLException;
import savinglives.dao.UserDAO;
import savinglives.dao.exception.DAOException;
import savinglives.model.User;
import savinglives.service.exception.ServiceException;
import savinglives.validation.UserValidator;
import savinglives.validation.exceptions.InvalidUserException;

public class UserService {
    /**
     * Registers a new user.
     *
     * @param user The user object to be registered.
     * @return true if the registration is successful, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     */
    public boolean registerUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();

        try {
            UserValidator.validateUser(user);
            if (userDAO.createUser(user)) {
                System.out.println(user.getUsername() + " successfully registered!");
                return true;
            } else {
                System.out.println("Registration not successful!");
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Logs in a user using email and password credentials.
     *
     * @param email    The user's email address.
     * @param password The user's password.
     * @return true if the login is successful, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     * @throws DAOException      If there's a problem with the data access.
     * @throws SQLException     If there's a problem with the database.
     */
    public boolean loginUser(String email, String password) throws ServiceException, DAOException, SQLException {
        UserDAO userDAO = new UserDAO();
        User loginUser = userDAO.login(email, password);

        if (email == null || password == null) {
            throw new ServiceException("Invalid User Credentials");
        }

        if (!UserValidator.validateEmail(email)) {
            throw new ServiceException("Invalid Email");
        }

        if (!UserValidator.validatePassword(password)) {
            throw new ServiceException("Invalid Password");
        }

        if (loginUser != null) {
            System.out.println(loginUser.getUsername() + " Login Successfully !");
            return true;
        } else {
            return false;
        }
    }
}
