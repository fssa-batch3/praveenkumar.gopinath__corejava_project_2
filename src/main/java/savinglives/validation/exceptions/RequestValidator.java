package savinglives.validation.exceptions;

import java.util.regex.Pattern;

import savinglives.model.Request;

public class RequestValidator {

	public static boolean Validation(Request request) throws InvalidUserException {

		if (request != null && Validategroup(request.getgroup()) && Validatedate(request.getdate())
				&& Validatenumber(request.getnumber())) {
			return true;
		} else {
			return false;
		}
	}

	// Pattern
	public static boolean Validategroup(String group) {
		boolean isMatch = false;

		String bloodGroupRegex = "^(A|B|AB|O)[+-]?$";
		isMatch = Pattern.matches(bloodGroupRegex, group);
		if (isMatch) {
			System.out.println("The request Blood group is validate");
		} else {
			System.out.println("The request Blood group is not validate");
		}
		return isMatch;
	}

	public static boolean Validatedate(String date) {

		boolean isMatch = false;
		String dateRegex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
		isMatch = Pattern.matches(dateRegex, date);

		if (isMatch) {
			System.out.println("The request Date is validate");
		} else {
			System.out.println("The request Date is not validate");
		}
		return isMatch;
	}

	public static boolean Validatenumber(String number) {
		boolean isMatch = false;

		String phoneNumberRegex = "^[0-9]{10}$";
		isMatch = Pattern.matches(phoneNumberRegex, number);

		if (isMatch) {
			System.out.println("The request Number is validate");
		} else {
			System.out.println("The request Number is not validate");
		}
		return isMatch;
	}

}
