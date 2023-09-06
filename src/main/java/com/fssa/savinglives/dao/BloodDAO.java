package com.fssa.savinglives.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.savinglives.dao.exception.DAOException;
import com.fssa.savinglives.model.Blood;
import com.fssa.savinglives.model.User;
import com.fssa.savinglives.utils.ConnectionUtil;

public class BloodDAO {
	/*
	 * Define the method to create a new donor in the database
	 */
	public static boolean create(Blood blood) throws DAOException {
		// the SQL query for inserting a new donor
		final String QUERY = "INSERT INTO product (donor, age,  blood_group, status, donated_date) VALUES (?, ?, ?, ?,?)";

		// Start a try block with a prepared statement for the insert query
		try (Connection connection = ConnectionUtil.getConnection();

				PreparedStatement pmt = connection.prepareStatement(QUERY)) {

			pmt.setString(1, blood.getDonor());
			pmt.setInt(2, blood.getAge());
			pmt.setString(3, blood.getBloodGroup());
			pmt.setString(4, blood.getStatus());
			pmt.setString(5, blood.getDonatedDate());
			int rowsAffected = pmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException("Error in Creating a Blood Donor", e);
		}
	}

	public static List<Blood> getAllBloods() throws DAOException {
		List<Blood> blood1 = new ArrayList<>();

		final String QUERY = "SELECT donor, age, blood_group, status, donate_date, donor FROM blood";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY);
				ResultSet rs = pmt.executeQuery()) {
			while (rs.next()) {
				String donor = rs.getString("donor");
				int age = rs.getInt("age");
				String bloodGroup = rs.getString("blood_group");
				String status = rs.getString("status");
				String donatedDate = rs.getString("donated_date");

				String email = rs.getString("email");
				User user = new User();
				user.setEmail(email);

				blood1.add(new Blood(donor, age, bloodGroup, status, donatedDate, user));

			}
			return blood1;

		} catch (SQLException e) {
			throw new DAOException("Error in getting All Donors", e);
		}

	}

	public static Blood findByDonor(String donor) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM blood WHERE donor = ?";

		Blood blood = new Blood();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(SELECTQUERY)) {

			pmt.setString(1, donor);

			try (ResultSet rs = pmt.executeQuery()) {
				if (rs.next()) {
					blood.setDonor(rs.getString("donor"));
					blood.setAge(rs.getInt("age"));
					blood.setBloodGroup(rs.getString("bloodGroup"));
					blood.setStatus(rs.getString("status"));
					blood.setDonatedDate(rs.getString("donatedDate"));
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return blood;
	}

	public boolean update(Blood blood) throws DAOException {
		final String SELECTQUERY = "UPDATE blood SET  donor=?,age=?,blood_group=?,status=?,donated_date WHERE donor=?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {
			stmt.setString(1, blood.getDonor());
			stmt.setInt(2, blood.getAge());
			stmt.setString(3, blood.getBloodGroup());
			stmt.setString(4, blood.getStatus());
			stmt.setString(5, blood.getDonatedDate());

			int rows = stmt.executeUpdate();

			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException("Error while updating donor details");
		}
	}

	public boolean delete(String donor) throws DAOException {
		final String SELECTQUERY = "DELETE from blood WHERE donor=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {

			stmt.setString(1, donor);

			int rows = stmt.executeUpdate();

			return rows > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in delete donor method", e);
		}

	}

}