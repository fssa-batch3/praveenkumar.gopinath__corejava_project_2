package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.savinglives.utils.*;

import com.fssa.savinglives.enums.DonorBloodGroup;
import com.fssa.savinglives.enums.DonorDistrict;
import com.fssa.savinglives.enums.DonorGender;
import com.fssa.savinglives.enums.DonorState;
import com.fssa.savinglives.logger.Logger;
import com.fssa.savinglives.model.DonorRegister;

public class DonorRegisterDao {
	public static void createDonorRegister(DonorRegister donorCreate) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "INSERT INTO donor(email_id,name,age,gender,blood_group,address,state,district,mobile_number) VALUES (?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, donorCreate.getEmailId());
				pst.setString(2, donorCreate.getName());
				pst.setInt(3, donorCreate.getAge());
				pst.setString(4, donorCreate.getGender().getValue());
				pst.setString(5, donorCreate.getBloodtype().getValue());
				pst.setString(6, donorCreate.getAddress());
				pst.setString(7, donorCreate.getState().getValue());
				pst.setString(8, donorCreate.getDistrict().getValue());
				pst.setString(9, donorCreate.getMobileNo());
				
				
				
				
				
				
				

				pst.executeUpdate();

				connection.close();
			}
		} catch (SQLException e) {
			// Print any SQLException error messages
			e.printStackTrace();
			Logger.info(e.getMessage());
		}
	}

	public static int getIdByEmailId(String email) {

		// Try-with-resources block to automatically close the connection
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create update statement
			String query = "SELECT donor_id FROM donor WHERE  email_id=?";

			// Create prepared statement for the update query
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				// Set parameters for the prepared statement
				pst.setString(1, email);

				ResultSet rs = pst.executeQuery();

				int id = 0;
				while (rs.next()) {
					id = rs.getInt("id");
				}
				// Close the connection
				connection.close();
				Logger.info("Fetched id successfully by email id " + email + " " + id);
				return id;

			}
		} catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
		return 0;
	}

	public static ArrayList<DonorRegister> getAllDonorDetails() {

		// Try-with-resources block to automatically close the connection
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create update statement
			String query = "SELECT * FROM donor ";

			// Create prepared statement for the update query
			try (PreparedStatement pst = connection.prepareStatement(query)) {

				ResultSet rs = pst.executeQuery();
				ArrayList<DonorRegister> donorDetails = new ArrayList<DonorRegister>();

				while (rs.next()) {
					DonorRegister donorRegister = new DonorRegister();

					donorRegister.setName(rs.getString("name"));
					donorRegister.setMobileNo(rs.getString("mobile_number"));
					donorRegister.setBloodtype(DonorBloodGroup.valueToEnumMapping(rs.getString("blood_group")));
					donorRegister.setAddress(rs.getString("address"));
					donorRegister.setState(DonorState.valueToEnumMapping(rs.getString("state")));
					donorRegister.setDistrict(DonorDistrict.valueToEnumMapping(rs.getString("district")));
					donorRegister.setAge(rs.getInt("age"));
					donorRegister.setEmailId(rs.getString("email_id"));
					donorRegister.setGender(DonorGender.valueToEnumMapping(rs.getString("gender")));
					donorDetails.add(donorRegister);
				}

				return donorDetails;

			}
		} catch (SQLException e) {
			// Print any SQLException error messages
			Logger.info(e.getMessage());
		}
		return null;

	}

	public static boolean deleteDonorReg(String email) throws IllegalArgumentException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			// Create the DELETE query
			String deleteQuery = "DELETE FROM donor WHERE email_id=?";

			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				// Set the id as the parameter for the DELETE query
				psmt.setString(1, email);

				// Execute the delete statement and get the number of affected rows
				int rowAffected = psmt.executeUpdate();

				Logger.info("donor register email deleted successfully");
				// Return true if at least one row was affected (deleted), false otherwise
				return rowAffected > 0;
			}
		} catch (SQLException e) {
			// Throw an exception with an error message if a SQL error occurs
			throw new IllegalArgumentException("Error while deleting donor: " + e.getMessage());
		}
	}
}