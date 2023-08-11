package savinglives.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import savinglives.dao.exception.DAOException;
import savinglives.model.Request;

public class RequestDAO {
	// connection to database

	public Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "123456");
		return connection;
	}

	// Insert request

	public boolean createRequest(Request request) throws DAOException {
		try {
			Connection connection = getConnection();

			String query = "INSERT INTO request (title,description,bloodgroup,date,number) VALUES(?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);

			state.setString(1, request.gettitle());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setString(4, request.getdate());
			state.setString(5, request.getid());
			state.setString(6, request.getnumber());

			int row = state.executeUpdate();
			state.close();
			connection.close();
			return (row == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// read query

	public boolean readRequest(Request request) throws DAOException {

		try {
			Connection connection = getConnection();

			String readquery = "SELECT * FROM blood.request";
			PreparedStatement state = connection.prepareStatement(readquery);

			ResultSet resultSet = state.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				String group = resultSet.getString("group");
				String date = resultSet.getString("date");
				String number = resultSet.getString("number");
				String id = resultSet.getString("id");

				System.out.println("title: " + title);
				System.out.println("description: " + description);
				System.out.println("group: " + group);
				System.out.println("date: " + date);
				System.out.println("number: " + number);
				System.out.println("id: " + id);

				resultSet.close();
				state.close();
				connection.close();

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return false;
	}

	public boolean updateRequest(Request request) throws DAOException {
		try {
			Connection connection = getConnection();

			String updatequery = "UPDATE user SET title = ?,description = ?, bloodgroup = ?,date = ?, number = ?, id = ?";
			PreparedStatement state = connection.prepareStatement(updatequery);

			state.setString(1, request.gettitle());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setString(4, request.getdate());
			state.setString(6, request.getnumber());
			state.setString(5, request.getid());

			int row = state.executeUpdate();
			return (row == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
