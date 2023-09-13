package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.utils.ConnectionUtil;
import com.fssa.savinglives.model.Request;


public class RequestDAO {

	// Insert request

	public boolean createrequest(Request request) throws DAOException {
		try {
			Connection connection = ConnectionUtil.getConnection();

			String query = "INSERT INTO request (title, description, bloodgroup, date, number, email) VALUES(?,?,?,?,?,?)";
			PreparedStatement state = connection.prepareStatement(query);

			state.setString(1, request.gettitle());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setDate(4, Date.valueOf(request.getdate()));
			state.setLong(5, request.getnumber());
			state.setString(6, request.getemail());

			int row = state.executeUpdate();
			state.close();
			connection.close();
			return (row == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public static void main(String[] args) {
		Request req = new Request();
		req.settitle("I need a blood");
		req.setdescription("i need help");
		req.setgroup("A+");
		LocalDate dt =LocalDate.now(); 
		req.setdate(dt);
		req.setnumber(6380843014l);
		req.setemail("arun@gmail.com");
		
		
		
		
		try {
			System.out.println(new RequestDAO().createrequest(req));
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	// read query

	public List<Request> readrequest() throws DAOException {

		List<Request> list = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();

			String readquery = "select * from request where is_deleted=0";
			PreparedStatement state = connection.prepareStatement(readquery);

			ResultSet resultSet = state.executeQuery();

			while (resultSet.next()) {
				
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				String group = resultSet.getString("bloodgroup");

				java.sql.Date sqlDate = resultSet.getDate("date");
                LocalDate localDate = sqlDate.toLocalDate();
				
				String email = resultSet.getString("email");
				int id = resultSet.getInt("id");
				
				Request req = new Request();
				
				req.settitle(title);
				req.setdescription(description);
				req.setgroup(group);
				req.setdate(localDate);
				req.setemail(email);
				req.setId(id);
				
				
       
				list.add(req);

				

			}
			resultSet.close();
			state.close();
			connection.close();
			
			return list;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean updaterequest(Request request, String email) throws DAOException {
		try {
			Connection connection = ConnectionUtil.getConnection();

			String updatequery = "UPDATE request SET title = ?,description = ?, bloodgroup = ?,date = ?, number = ? WHERE email = ?";
			PreparedStatement state = connection.prepareStatement(updatequery);

			state.setString(1, request.gettitle());
			state.setString(2, request.getdescription());
			state.setString(3, request.getgroup());
			state.setDate(4, Date.valueOf(request.getdate()));
			state.setLong(5, request.getnumber());
			state.setString(6, request.getemail());

			int row = state.executeUpdate();
			return (row == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean sameEmailExist(String email) throws SQLException, DAOException {
		boolean match = false;
		int count = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM request WHERE email = ?");) {

			pst.setString(1, email);
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String email1 = resultSet.getString("email");
					System.out.println("email: " + email1);
					if (email.toLowerCase().trim().equals(email1)) {
						count++;
					}
				}
			}

			if (count > 0) {
				match = true;
			}
		} catch (SQLException e) {
			throw new DAOException("Error: " + e);
		}

		return match;
	}
	

	
	//get all users list
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
//	public List<Request> getAllRequests() throws DAOException {
//	    final String selectRequestListQuery = "SELECT * FROM blood.request"; // Correct the table name
//	    
//	    List<Request> requests = new ArrayList<>();
//	    
//	    try (Connection connection = getConnection();
//	         PreparedStatement statement = connection.prepareStatement(selectRequestListQuery);
//	         ResultSet rs = statement.executeQuery()) {
//	        
//	        while (rs.next()) {
//	            int id = rs.getInt("id"); // Assuming you have an 'id' field
//	            String title = rs.getString("title");
//	            String description = rs.getString("description");
//	            String bloodgroup = rs.getString("bloodgroup");
//	            LocalDate date = rs.getDate("date").toLocalDate(); // Convert SQL Date to LocalDate
//	            Long number = rs.getLong("number");
//	            String email = rs.getString("email");
//	            // Assuming 'is_driver' is a boolean column
//	            boolean isDriver = rs.getBoolean("is_driver");
//
//	            // Create a new Request object with retrieved values
//	            Request request = new Request(title, description, bloodgroup, date, number, email);
//	            
//	            requests.add(request);
//	        }
//	    } catch (SQLException e) {
//	        throw new DAOException(e);
//	    }
//	    
//	    return requests;
//	}

	
	

	public boolean deleterequest(String email) throws DAOException {
		try {
			// Get connection
			Connection connection = ConnectionUtil.getConnection();

			// Prepare SQL statement
			String deleteQuery = "UPDATE request SET is_deleted = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, 1);
			statement.setString(2, email);
			
			

			// Execute the query
			int rows = statement.executeUpdate();

			statement.close();
			connection.close();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}