package com.fssa.savinglives.validation;

import java.util.regex.Pattern;


import com.fssa.savinglives.model.Request;
import com.fssa.savinglives.validation.exceptions.InvalidRequestException;

public class RequestValidator {

    public static boolean validation(Request request) throws InvalidRequestException {

        if (request != null
                && validateGroup(request.getbloodgroup())
                && validateDate(request.getdate())
                && Validatenumber(request.getnumber())) {
            return true;
        } else {
            return false;
        }
    }

    // Pattern
    public static boolean validateGroup(String group) throws InvalidRequestException {
        boolean isMatch = false;
        try {
            String bloodGroupRegex = "^(A|B|AB|O)[+-]?$";
            isMatch = Pattern.matches(bloodGroupRegex, group);
            if (isMatch) {
                System.out.println("The request Blood group is valid");
            } else {
                throw new InvalidRequestException("Blood group is not valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return isMatch;
    }

    public static boolean validateDate(String date) throws InvalidRequestException {

        boolean isMatch = false;
        if (date == null) {
            return false;
        }

        try {
            String dateRegex = "^(\\d{4})-(\\d{2})-(\\d{2})$";
            isMatch = Pattern.matches(dateRegex, date);

            if (isMatch) {
                System.out.println("The request Date is valid");
            } else {
                throw new InvalidRequestException("The request date is not valid");
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
                System.out.println("The request Number is valid");
            } else {
                throw new InvalidRequestException("The request Number is not valid");
            }
        } catch (InvalidRequestException e) {
            System.out.println(e.getMessage());
        }

        return isMatch;
    }
}
