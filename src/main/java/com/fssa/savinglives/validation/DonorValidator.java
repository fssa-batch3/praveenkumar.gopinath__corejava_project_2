package com.fssa.savinglives.validation;


import java.util.regex.Pattern;

import com.fssa.savinglives.enums.BloodGroup;
import com.fssa.savinglives.enums.DonorBloodGroup;
import com.fssa.savinglives.enums.DonorDistrict;
import com.fssa.savinglives.enums.DonorGender;
import com.fssa.savinglives.enums.DonorState;
import com.fssa.savinglives.validation.exceptions.InvalideDonorRegisterException;
import com.fssa.savinglives.model.DonorRegister;


public class DonorValidator {
	public static final String NUMBER_REGEX = "^[-+]?[0-9]+(\\.[0-9]+)?$";
	  public static String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static boolean validateDonorRequest(DonorRegister donorReqestValidate) throws InvalideDonorRegisterException {
		validateName(donorReqestValidate.getName());
		
		validateMobileNo(donorReqestValidate.getMobileNo());
		
		validateBloodType(donorReqestValidate.getBloodtype());
		
		validateAddress(donorReqestValidate.getAddress());
		
		validateState(donorReqestValidate.getState());
		
		validateDistrict(donorReqestValidate.getDistrict());
		
		validateAge(donorReqestValidate.getAge());
		
		validateEmail(donorReqestValidate.getEmailId());
		
		validateGender(donorReqestValidate.getGender());
			
		return true;
	}
	
	public static boolean validateName(String name) throws InvalideDonorRegisterException {
	    // Check if the provided name is not null or empty.
	    if (name == null || name.isEmpty()) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new InvalideDonorRegisterException("Name cannot be null or empty");
	    }

	    // Check if the name contains only letters and spaces.
	    if (!name.matches("^[a-zA-Z\\s]+$")) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new InvalideDonorRegisterException("Name must contain only letters and spaces");
	    }

	    // Check if the name length is within a reasonable range.
	    if (name.length() < 2 || name.length() > 50) {
	        // If the condition is met, throw a ValidationException with a specific error message.
	        throw new InvalideDonorRegisterException("Name length must be between 2 and 50 characters");
	    }

	    // If all checks pass, return true to indicate that the validation check has passed.
	    return true;
	}
	
	public static boolean validateMobileNo(String MobileNo) throws InvalideDonorRegisterException {
		// Check if the provided "ContactNo" is null.
		if (MobileNo == null) {
			// If the condition is met, throw an IllegalArgumentException with a specific
			// error message.
			throw new InvalideDonorRegisterException("type the correct number");
		}

		// Use a regular expression pattern to match the provided "ContactNo" against a
		// predefined pattern.
		// The "NUMBER_REGEX" variable should be defined elsewhere in your code.
		boolean match = Pattern.matches(NUMBER_REGEX, MobileNo);

		// Check if the "ContactNo" did not match the expected pattern.
		if (!match) {
			// If the condition is met, throw an IllegalArgumentException with a specific
			// error message.
			throw new InvalideDonorRegisterException("type the correct number");
		}

		// Return true to indicate that the validation check has passed.
		return true;
	}
	
	public static boolean validateBloodType(DonorBloodGroup donorBloodGroup) throws InvalideDonorRegisterException {
		// Create a new instance of the BloodRequest class.
		DonorRegister req = new DonorRegister();

		// Iterate through all possible values of the BloodGroup enum using a for-each
		// loop.
		for (BloodGroup grp : BloodGroup.values()) {
			// Check if the value of the current enum element "grp" is equal to the
			// "bloodtype" from the input.
			if (grp.value.equals(req.getBloodtype())) {
				// If the condition is met, throw an IllegalArgumentException with a specific
				// error message.
				throw new InvalideDonorRegisterException("write the correct blood type");
			}
		}

		// Return true to indicate that the validation check has passed.
		return true;
	}
	public static boolean validateAddress(String address) throws InvalideDonorRegisterException {
	    if (address == null || address.length()>500) {
	        throw new InvalideDonorRegisterException("Address cannot be null or empty");
	    }
	    // You can add more specific validation criteria for addresses if needed.
	    return true;
	}
	public static boolean validateState(DonorState state) throws InvalideDonorRegisterException {
	    // Assuming DonorState is an enum representing valid states
	    boolean isValidState = false;

	    // Iterate through all possible values of the DonorState enum using a for-each loop.
	    for (DonorState validState : DonorState.values()) {
	        // Check if the value of the current enum element "validState" is equal to the "state" from the input.
	        if (validState == state) {
	            isValidState = true;
	            break;
	        }
	    }

	    // If the state is not found in the enum values, it's invalid.
	    if (!isValidState) {
	        throw new InvalideDonorRegisterException("Invalid state");
	    }

	    // Return true to indicate that the validation check has passed.
	    return true;
	}

	public static boolean validateDistrict(DonorDistrict district) throws InvalideDonorRegisterException {
	    // Assuming DonorDistrict is an enum representing valid districts
	    boolean isValidDistrict = false;
	    System.out.println(district);
	    // Iterate through all possible values of the DonorDistrict enum using a for-each loop.
	    for (DonorDistrict validDistrict : DonorDistrict.values()) {
	        // Check if the value of the current enum element "validDistrict" is equal to the "district" from the input.
	        if (validDistrict.equals(district)) {
	            isValidDistrict = true;
	            break;
	        }
	    }

	    // If the district is not found in the enum values, it's invalid.
	    if (!isValidDistrict) {
	        throw new InvalideDonorRegisterException("Invalid district");
	    }

	    // Return true to indicate that the validation check has passed.
	    return true;
	}
	public static boolean validateAge(int age) throws InvalideDonorRegisterException {
	    // Define the minimum and maximum age values
	    int minAge = 18;
	    int maxAge = 100;

	    // Check if the provided age is within the specified range
	    if (age < minAge || age > maxAge) {
	        throw new InvalideDonorRegisterException("Age must be between " + minAge + " and " + maxAge);
	    }

	    // Return true to indicate that the validation check has passed
	    return true;
	}
	

	public static boolean validateEmail(String emailId) throws InvalideDonorRegisterException {
	    // Define a regular expression pattern for a valid email address
	 

	    // Use the Pattern class to compile the regular expression
	    Pattern pattern = Pattern.compile(emailRegex);

	    // Use the Matcher class to perform the matching
	    if (emailId == null || !pattern.matcher(emailId).matches()) {
	        throw new InvalideDonorRegisterException("Invalid email address format");
	    }

	    // Return true to indicate that the validation check has passed
	    return true;
	}
	
	public static boolean validateGender(DonorGender gender) throws InvalideDonorRegisterException {
	    // Assuming DonorGender is an enum representing valid genders

	    // Create a boolean flag to check if the provided gender is valid
	    boolean isValidGender = false;
	    System.out.println(gender);
	    // Iterate through all possible values of the DonorGender enum using a for-each loop
	    for (DonorGender validGender : DonorGender.values()) {
	        // Check if the value of the current enum element "validGender" is equal to the "gender" from the input
	        if (validGender.equals(gender)) {
	            isValidGender = true;
	            break; // Exit the loop when a valid gender is found
	        }
	    }

	    // If the provided gender is not found in the enum values, it's invalid
	    if (!isValidGender) {
	        throw new InvalideDonorRegisterException("Invalid gender");
	    }

	    // Return true to indicate that the validation check has passed
	    return true;
	}


}