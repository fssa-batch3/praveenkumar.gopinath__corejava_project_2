package savinglives.validation;

import java.util.regex.Pattern;

import savinglives.model.Request;
import savinglives.validation.exceptions.InvalidUserException;

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
		boolean match = false;

		String bloodGroupRegex = "^(A|B|AB|O)[+-]?$";
		match = Pattern.matches(bloodGroupRegex, group);
		if (match) {
			System.out.println("The request Blood group is validate");
		} else {
			System.out.println("The request Blood group is not validate");
		}
		return match;
	}

	public static boolean Validatedate(String date) {

		boolean match = false;
		String dateRegex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
		match = Pattern.matches(dateRegex, date);

		if (match) {
			System.out.println("The request Date is validate");
		} else {
			System.out.println("The request Date is not validate");
		}
		return match;
	}

	public static boolean Validatenumber(String number) {
		boolean match = false;

		String phoneNumberRegex = "^[0-9]{10}$";
		match = Pattern.matches(phoneNumberRegex, number);

		if (match) {
			System.out.println("The request Number is validate");
		} else {
			System.out.println("The request Number is not validate");
		}
		return match;
	}

}
