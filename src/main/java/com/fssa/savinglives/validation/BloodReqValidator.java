package com.fssa.savinglives.validation;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import com.fssa.savinglives.enums.BloodGroup;
import com.fssa.savinglives.model.BloodRequest;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class BloodReqValidator {

	private static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	private static final LocalDate MIN_DATE = LocalDate.of(2023, 1, 1);
	private static final LocalDate MAX_DATE = LocalDate.now();

	public static boolean validateBloodRequest(BloodRequest bloodRequest) throws InvalidRequestException {
		if (bloodRequest == null) {
			throw new InvalidRequestException("Blood Request details are not valid");
		}

		try {
			return validateName(bloodRequest.getName()) && valitadeAddress(bloodRequest.getAddress())
					&& validateTitle(bloodRequest.getTitle()) && validateDescription(bloodRequest.getDescription())
					&& validateBloodType(bloodRequest.getBloodType()) && validateReqDate(bloodRequest.getReqDate())
					&& validateContactNo(bloodRequest.getContactNo());
		} catch (InvalidRequestException e) {
			throw new InvalidRequestException(e.getMessage());
		}

	}

	public static boolean validateId(int reqId) throws InvalidRequestException {
		int idNo = 1;

		if (reqId <= idNo) {
			throw new InvalidRequestException("Id must be greater than Zero");
		}

		return true;
	}

	public static boolean validateName(String name) throws InvalidRequestException {
		if (name == null || name.isEmpty()) {
			throw new InvalidRequestException("Name cannot be null or empty");
		}

		if (!name.matches("^[a-zA-Z\\s]+$")) {
			throw new InvalidRequestException("Name must contain only letters and spaces");
		}

		if (name.length() < 2 || name.length() > 50) {
			throw new InvalidRequestException("Name length must be between 2 and 50 characters");
		}

		return true;
	}

	// Address

	public static boolean valitadeAddress(String address) throws InvalidRequestException {

		if (address == null || address.isEmpty()) {
			throw new InvalidRequestException("Address should not be null or empty");
		}
		if (!address.matches("^\\S+.*$")) {
			throw new InvalidRequestException("Address should be like this Ex;123 Main Street, Apt. 4B");

		}
		if (address.length() < 10 || address.trim().length() > 100) {
			throw new InvalidRequestException("Address length must be between 8 and 100 characters");
		}

		return true;
	}

	// Title

	public static boolean validateTitle(String title) throws InvalidRequestException {

		if (title == null || title.isEmpty()) {
			throw new InvalidRequestException("Give the proper value without null or Empty values");

		}

		if (!title.matches("^(A|B|AB|O)[+-]$")) {
			throw new InvalidRequestException("Tittle validation is Invalide");
		}
		if (title.length() < 2 || title.length() > 100) {
			throw new InvalidRequestException("Title length must be between 6 and 100 characters");
		}

		return true;
	}

	// Description

	public static boolean validateDescription(String description) throws InvalidRequestException {
		if (description == null || description.isEmpty()) {
			throw new InvalidRequestException("Give the proper value without empty or null values in description");
		}

		if (!description.matches("^\\d+\\s+units\\s+for\\s+.+$")) {
			throw new InvalidRequestException("Invalide Description");
		}
		if (description.length() < 10 || description.length() > 50) {
			throw new InvalidRequestException("Description length must be between 10 and 50 characters");
		}
		return true;
	}


	public static boolean validateBloodType(BloodGroup bloodtype) throws InvalidRequestException {
		BloodRequest req = new BloodRequest();
		
		

		for (BloodGroup grp : BloodGroup.values()) {
			if (grp.value.equals(req.getBloodType())) {
				throw new InvalidRequestException("write the correct blood type");
			}
		}

		return true;
	}

	// contact number

	public static boolean validateContactNo(String ContactNo) throws InvalidRequestException {
		if (ContactNo == null) {
			throw new InvalidRequestException("Give the correct number");
		}

		boolean match = Pattern.matches(NUMBER_REGEX, ContactNo);

		if (!match) {
			throw new InvalidRequestException("Give the correct number");
		}
		return true;
	}

	// Request Date

	public static boolean validateReqDate(LocalDate reqDate) throws InvalidRequestException {
		if (reqDate == null) {
			throw new InvalidRequestException("Give the correct reqDate");
		}
		if (reqDate.isBefore(MIN_DATE) || reqDate.isAfter(MAX_DATE)) {
			throw new InvalidRequestException("Give the correct requesting Date");
		}
		return true;
	}

	public static void validateGetAllBloodRequest(List<BloodRequest> bloodRequest) throws InvalidRequestException {

		if (bloodRequest == null || bloodRequest.isEmpty())
			throw new InvalidRequestException("There is no Blood Requests in the Data base");
	}

}
