package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.utils.ConnectionUtil;

public class RequestDAO {

	// Insert request

	public boolean createBloodReq(Request bloodCreate) throws DAOException {
		try {
			Connection connection = ConnectionUtil.getConnection();

			String query = "INSERT INTO request (name, address, title, description, bloodGroup_Type, req_Date, contact_No, req_Verification) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement st = connection.prepareStatement(query);

			st.setString(1, bloodCreate.getName());
			st.setString(2, bloodCreate.getAddress());
			st.setString(3, bloodCreate.getTitle());
			st.setString(4, bloodCreate.getDescription());
			st.setString(5, bloodCreate.getBloodType());
			st.setDate(6, Date.valueOf(bloodCreate.getReqDate()));
			st.setLong(7, bloodCreate.getContactNo());
			st.setString(8, bloodCreate.getVerification() ? "True" : "False");

			int row = st.executeUpdate();
			st.close();
			connection.close();
			System.out.println("Bloodrequest is added successfully ");
			return (row == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public static void updateBloodReq(Request bloodReqUpdate) {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "UPDATE request SET name = ?, title = ?,description = ?, bloodGroup_Type = ?, req_Date = ?, contact_No = ?, req_Verification = ? WHERE req_Id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, bloodReqUpdate.getBloodType());
				pst.setString(2, bloodReqUpdate.getDescription());
				pst.setLong(3, bloodReqUpdate.getContactNo());
				java.sql.Date reqDate = Date.valueOf(bloodReqUpdate.getReqDate());
				pst.setDate(4, reqDate);
				pst.setString(5, bloodReqUpdate.getVerification() ? "True" : "False");
				pst.setString(6, bloodReqUpdate.getName());
				pst.setLong(7, bloodReqUpdate.getContactNo());

				pst.executeUpdate();
				connection.close();
				System.out.println("Blood request is updated successfully ");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static boolean deleteBloodReq(int reqId) throws IllegalArgumentException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String deleteQuery = "DELETE FROM request WHERE req_Id=?";

			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				psmt.setInt(1, reqId);

				int rowAffected = psmt.executeUpdate();

				System.out.println("BloodRequest deleted successfully");
				return rowAffected > 0;
			}
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error while deleting request: " + e.getMessage());
		}
	}

}