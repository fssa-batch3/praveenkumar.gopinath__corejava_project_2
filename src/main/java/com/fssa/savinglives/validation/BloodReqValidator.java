package com.fssa.savinglives.validation;

import java.time.LocalDate;
import java.util.regex.Pattern;

import com.fssa.savinglives.model.*;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class BloodReqValidator {
	private static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	private static final LocalDate MIN_DATE = LocalDate.of(2020, 1, 1);
	private static final LocalDate MAX_DATE = LocalDate.now();

	public static boolean validateBloodRequest(Request bloodReqValidate) throws InvalidRequestException {
		validateName(bloodReqValidate.getName());

		validateBloodGroupType(bloodReqValidate.getBloodType());

		validateDescription(bloodReqValidate.getDescription());

		validateContactNo(bloodReqValidate.getContactNo());

		validateReqDate(bloodReqValidate.getReqDate());

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

	public static boolean validateId(int reqId) throws InvalidRequestException {
		int idNo = 1;

		if (reqId <= idNo) {
			throw new InvalidRequestException("Id must be greater than Zero");
		}

		return true;
	}

	public static boolean validateDescription(String description) throws InvalidRequestException {
		if (description == null || description.length() < 3) {
			throw new InvalidRequestException("Give the correct description");
		}
		return true;
	}

	public static void validateBloodGroupType(String bloodType) throws InvalidRequestException {

	}

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

	public static boolean validateReqDate(LocalDate reqDate) throws InvalidRequestException {
		if (reqDate == null) {
			throw new InvalidRequestException("Give the correct reqDate");
		}
		if (reqDate.isBefore(MIN_DATE) || reqDate.isAfter(MAX_DATE)) {
			throw new InvalidRequestException("Give the correct reqDate");
		}
		return true;
	}

}
