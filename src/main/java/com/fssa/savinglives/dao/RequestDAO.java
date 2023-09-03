package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;

public class RequestDAO {

	public static Connection getConnection() throws SQLException {

		String DB_URL = System.getenv("DB_URL");
		String DB_USER = System.getenv("DB_USER");
		String DB_PASSWORD = System.getenv("DB_PASSWORD"); 

		// Connecting to DB
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);// DB_URL;
																			// DB_USER;
																			// DB_PASSWORD;

	}

	public boolean createRequest(Request request) throws DAOException {
	    try (Connection connection = getConnection();
	            PreparedStatement ptsm = connection.prepareStatement(
	                    "INSERT INTO request (title, description, blood_group, date, number) VALUES(?,?,?,?,?)")) {

	        ptsm.setString(1, request.gettitle());
	        ptsm.setString(2, request.getdesc());
	        ptsm.setString(3, request.getbloodgroup());
	        ptsm.setString(4, request.getdate());
	        ptsm.setString(5, request.getnumber());

	        int rowsCreate = ptsm.executeUpdate();
	        return rowsCreate == 1;

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}
	
	
	public ArrayList<Request> getRequestsByBloodGroup(String bloodGroup) throws DAOException {
		ArrayList<Request> requests = new ArrayList<>();
	    try (Connection connection = getConnection();
	            PreparedStatement ptsm = connection.prepareStatement(
	                    "SELECT * FROM request WHERE blood_group = ?")) {

	        ptsm.setString(1, bloodGroup);

	        try (ResultSet resultSet = ptsm.executeQuery()) {
	            while (resultSet.next()) {
	                Request request = new Request(
	                        resultSet.getString("title"),
	                        resultSet.getString("description"),
	                        resultSet.getString("blood_group"),
	                        resultSet.getString("date"),
	                        resultSet.getString("number")
	                );
	                requests.add(request);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    return requests;
	}


	public boolean updateRequest(Request request) throws DAOException {
	    try (Connection connection = getConnection();
	            PreparedStatement ptsm = connection.prepareStatement(
	                    "UPDATE request SET title = ?, description = ?, blood_group = ?, date = ?, number = ?, isclosed = ?, closedBy = ?, closedondate = ? WHERE id = ?")) {

	        ptsm.setString(1, request.gettitle());
	        ptsm.setString(2, request.getdesc());
	        ptsm.setString(3, request.getbloodgroup());
	        ptsm.setString(4, request.getdate());
	        ptsm.setString(5, request.getnumber());
	        ptsm.setInt(9, request.getId());

	        int rowsUpdate = ptsm.executeUpdate();
	        return rowsUpdate == 1;

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}
	
	public boolean deleteRequest(int requestId) throws DAOException {
	    try (Connection connection = getConnection();
	            PreparedStatement ptsm = connection.prepareStatement(
	                    "DELETE FROM request WHERE id = ?")) {

	        ptsm.setInt(1, requestId);

	        int rowsDeleted = ptsm.executeUpdate();
	        return rowsDeleted == 1;

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


}
