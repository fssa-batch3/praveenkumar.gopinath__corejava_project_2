package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.enums.*;
import com.fssa.savinglives.model.BloodRequest;
import com.fssa.savinglives.utils.ConnectionUtil;

public class BloodRequestDAO {

	// Insert request

	public boolean createBloodReq(BloodRequest createRequest) throws DAOException {

		final String query = "INSERT INTO request (name, address, title, description, bloodGroup_Type, req_Date, contact_No, req_Verification) VALUES(?,?,?,?,?,?,?,?)";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement st = connection.prepareStatement(query)) {

			st.setString(1, createRequest.getName());
			st.setString(2, createRequest.getAddress());
			st.setString(3, createRequest.getTitle());
			st.setString(4, createRequest.getDescription());
			st.setString(5, createRequest.getBloodType().getValue());
			st.setDate(6, Date.valueOf(createRequest.getReqDate()));
			st.setString(7, createRequest.getContactNo());
			st.setString(8, createRequest.getReqVerification() ? "True" : "False");

			int row = st.executeUpdate();
			st.close();
			connection.close();
			System.out.println("Bloodrequest is created successfully ");
			return row == 1;

		} catch (SQLException e) {
			throw new DAOException("Error in create blood request", e);
		}
	}

	public static ArrayList<BloodRequest> getAllBloodRequest() throws DAOException {

		final String QUERY = "SELECT req_id, name, address, title, description, bloodGroup_Type, req_Date, contact_No, req_Verification FROM request";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY);
				ResultSet rs = pmt.executeQuery()) {

			ArrayList<BloodRequest> bloodReqList = new ArrayList<BloodRequest>();

			while (rs.next()) {
				BloodRequest newRequest = new BloodRequest();

				newRequest.setReqId(rs.getInt("reqId"));
				newRequest.setName(rs.getString("name"));
				newRequest.setAddress(rs.getString("address"));
				newRequest.setTitle(rs.getString("title"));
				newRequest.setDescription(rs.getString("description"));
				;
				newRequest.setBloodType(BloodGroup.valueToEnumMapping(rs.getString("bloodType")));
				newRequest.setReqDate(rs.getDate("reqDate").toLocalDate());
				newRequest.setContactNo(rs.getString("contactNo"));

				newRequest.setReqVerification(rs.getString("reqVerification").equals("True") ? true : false);

				bloodReqList.add(newRequest);
			}

			return bloodReqList;
		}

		catch (SQLException e) {
			throw new DAOException("Error in getting All Request list", e);
		}

	}

	public boolean updateBloodReq(BloodRequest bloodReqUpdate) throws DAOException {
		final String SELECTQUERY = "UPDATE request SET name = ?, title = ?, description = ?, bloodGroup_Type = ?, req_Date = ?, contact_No = ?, req_Verification = ? WHERE req_Id = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement st = connection.prepareStatement(SELECTQUERY)) {
			st.setString(1, bloodReqUpdate.getName());
			st.setString(2, bloodReqUpdate.getAddress());
			st.setString(3, bloodReqUpdate.getTitle());
			st.setString(4, bloodReqUpdate.getDescription());
			st.setString(5, bloodReqUpdate.getBloodType().getValue());
			java.sql.Date reqDate = Date.valueOf(bloodReqUpdate.getReqDate());
			st.setDate(6, reqDate);
			st.setString(7, bloodReqUpdate.getContactNo());
			st.setString(8, bloodReqUpdate.getReqVerification() ? "True" : "False");
			int rows = st.executeUpdate();
			st.close();
			connection.close();
			System.out.println("Blood request is updated successfully");

			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException("Error in updateing the blood request ", e);

		}

	}

	public static boolean deleteBloodReq(int reqId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String deleteQuery = "DELETE FROM request WHERE req_Id=?";

			try (PreparedStatement st = connection.prepareStatement(deleteQuery)) {
				st.setInt(1, reqId);

				int row = st.executeUpdate();

				System.out.println("Blood request deleted successfully");
				return row > 0;
			}
		} catch (SQLException e) {
			throw new DAOException("Error while deleting request: ", e);
		}
	}

}