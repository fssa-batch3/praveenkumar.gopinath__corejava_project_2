package savinglives.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import savinglives.dao.exception.DAOException;
import savinglives.model.Request;

public class RequestDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/savinglives";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "123456";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public boolean createRequest(Request request) throws DAOException {
		try (Connection connection = getConnection();
				PreparedStatement ptsm = connection.prepareStatement(
						"INSERT INTO request (title, description, blood_group, date, number) VALUES(?,?,?,?,?)")) {

			ptsm.setString(1, request.gettitle());
			ptsm.setString(2, request.getdesc());
			ptsm.setString(3, request.getblood_group());
			ptsm.setString(4, request.getdate());
			ptsm.setString(5, request.getnumber());

			int rowsCreate = ptsm.executeUpdate();
			return rowsCreate == 1;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	


	public boolean updateRequest(Request request) throws DAOException {
		try (Connection connection = getConnection();
				PreparedStatement ptsm = connection.prepareStatement(
						"UPDATE request SET title = ?, description = ?, blood_group = ?, date = ?, number = ?")) {

			ptsm.setString(1, request.gettitle());
			ptsm.setString(2, request.getdesc());
			ptsm.setString(3, request.getblood_group());
			ptsm.setString(4, request.getdate());
			ptsm.setString(5, request.getnumber());

			int rowsUpdate = ptsm.executeUpdate();
			return rowsUpdate == 1;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
