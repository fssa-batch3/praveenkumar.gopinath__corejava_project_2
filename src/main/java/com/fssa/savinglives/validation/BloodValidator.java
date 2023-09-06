package com.fssa.savinglives.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.savinglives.model.Blood;
import com.fssa.savinglives.validation.exceptions.InvalideBloodException;

public class BloodValidator {

    public static boolean validateBlood(Blood blood) throws InvalideBloodException {
        if (blood == null) {
            throw new InvalideBloodException("Donor details are not valid");
        }

        try {
            return validateDonor(blood.getDonor()) && validateAge(blood.getAge())
                    && validateBloodGroup(blood.getBloodGroup()) && validateDonorStatus(blood.getStatus())
                    && validateDonatedDate(blood.getDonatedDate());
        } catch (InvalideBloodException e) {
            throw new InvalideBloodException("Donor inputs details are not valid");
        }
    }

    public static void validateGetAllDonors(List<Blood> bloodList) throws InvalideBloodException {
        if (bloodList == null || bloodList.isEmpty()) {
            throw new InvalideBloodException("There is no Donor");
        }
    }

    public static boolean validateDonor(String donorName) throws InvalideBloodException {
        String regex = "^[A-Za-z\\s]{2,50}$"; // Alphabetic characters and spaces, between 2 to 50 characters.
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(donorName);
        boolean match = m.matches();

        if (match) {
            return true;
        } else {
            throw new InvalideBloodException(
                    "Invalid donor name format. The name should be alphabetic and between 2 to 50 characters.");
        }
    }

    public static boolean validateAge(int age) throws InvalideBloodException {
        if (age >= 18 && age <= 100) { // Assuming a reasonable age range for donors
            return true;
        } else {
            throw new InvalideBloodException("Invalid age. Donor age should be between 18 and 100.");
        }
    }

    public static boolean validateBloodGroup(String bloodGroup) throws InvalideBloodException {
        String regex = "^(A|B|AB|O)[\\+-]$"; // Valid blood group patterns (A+, B-, AB+, O-, etc.)
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(bloodGroup);
        boolean match = m.matches();

        if (match) {
            return true;
        } else {
            throw new InvalideBloodException(
                    "Invalid blood group format. Please provide a valid blood group (e.g., A+, B-, AB+).");
        }
    }

    public static boolean validateDonorStatus(String status) throws InvalideBloodException {
        if (status != null && !status.isEmpty()) {
            return true;
        } else {
            throw new InvalideBloodException("Invalid donor status. Please provide a valid status.");
        }
    }

    public static boolean validateDonatedDate(String donatedDate) throws InvalideBloodException {
        if (donatedDate == null) {
            throw new InvalideBloodException("Donated date is required.");
        }

        String dateRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        boolean isMatch = Pattern.matches(dateRegex, donatedDate);

        if (isMatch) {
            return true;
        } else {
            throw new InvalideBloodException("Invalid donated date format. Please provide a valid date in the format 'yyyy-MM-dd'.");
        }
    }
}
