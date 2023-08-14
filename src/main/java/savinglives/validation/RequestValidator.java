package savinglives.validation;

import java.util.regex.Pattern;

import savinglives.model.Request;
import savinglives.validation.exceptions.InvalidRequestException;
import savinglives.validation.exceptions.InvalidUserException;

public class RequestValidator {

	public static boolean Validation(Request request) throws InvalidRequestException {

		if (request != null && Validategroup(request.getblood_group()) && Validatedate(request.getdate())
				&& Validatenumber(request.getnumber())) {
			return true;
		} else {
			return false;
		}
	}

	// Pattern
	public static boolean Validategroup(String group) throws InvalidRequestException {
		boolean isMatch = false;
		try {
			String bloodGroupRegex = "^(A|B|AB|O)[+-]?$";
			isMatch = Pattern.matches(bloodGroupRegex, group);
			if (isMatch) {
				System.out.println("The request Blood group is validate");
			} else {
				throw new InvalidUserException("blood group is not valid");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return isMatch;
	}

	public static boolean Validatedate(String date) throws InvalidRequestException {

		boolean isMatch = false;
		if (date == null) {

			return false;
		}

		try {
			String dateRegex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
			isMatch = Pattern.matches(dateRegex, date);

			if (isMatch) {
				System.out.println("The request Date is validate");
			} else {
				throw new InvalidUserException("The request date is not validate");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return isMatch;
	}

	public static boolean Validatenumber(String number) throws InvalidRequestException {
		boolean isMatch = false;
		if (number == null) {

			return false;
		}

		try {

			String phoneNumberRegex = "^[0-9]{10}$";
			isMatch = Pattern.matches(phoneNumberRegex, number);

			if (isMatch) {
				System.out.println("The request Number is validate");
			} else {
				throw new InvalidRequestException("The request Number is not validate");
			}
		} catch (InvalidRequestException e) {

			System.out.println(e.getMessage());
		}

		return isMatch;
	}

}
