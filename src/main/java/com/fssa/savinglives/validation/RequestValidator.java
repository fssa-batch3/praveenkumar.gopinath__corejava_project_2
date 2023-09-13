package com.fssa.savinglives.validation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.validation.exceptions.InvalidUserException;

public class RequestValidator {
	
	public static boolean Validation(Request request)throws  InvalidUserException{
		boolean match = false;
		if(request != null  && Validategroup(request.getgroup()) && Validatenumber(request.getnumber())) {
			return true;
		}else {
			return false;
		}
	}

	

  


	//Pattern
	public static boolean Validategroup(String group) {
		boolean match = false;
		
		String bloodGroupRegex = "^(A|B|AB|O)[+-]?$";
		match = Pattern.matches(bloodGroupRegex,group);
		if(match) {
			System.out.println("Blood group is valid");
		}else {
			System.out.println("Blood group is Invalid");
		}
		return match;
		}
	


	public static boolean Validatedob(Date date) {
		if (date == null)
			return false;

		LocalDate dob = date.toLocalDate();

		// Perform your date of birth validation here
		LocalDate currentDate = LocalDate.now();
		LocalDate minDob = currentDate.minusYears(120);
		LocalDate maxDob = currentDate.minusYears(5);

		boolean isValidDob = (dob.isAfter(minDob) && dob.isBefore(maxDob));

		if (isValidDob) {
			System.out.println("Date is valid");
		} else {
			System.out.println("Date is  Invalid");
		}

		return isValidDob;
	}

	
	
	
	

		public static boolean Validatenumber(long l) {
			boolean match = false;
			
			String phoneNumberRegex = "^[0-9]{10}$";
			match = Pattern.matches(phoneNumberRegex, Long.toString(l));
			
			if(match) {
				System.out.println("PhoneNumber is valid");
			}else {
				System.out.println("PhoneNumber is Invalid");
			}
			return match;
			}
			
		
}
