package com.fssa.savinglives.enums;

import java.util.HashMap;

public enum DonorGender {
	MALE("Male"), FEMALE("Female");

	// Property to store the value of each enum constant
	public final String value;

	// Constructor to initialize the enum constants with values
	DonorGender(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	}

	// Static method to map a string value to the corresponding enum constant
	public static DonorGender valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, DonorGender> valueToEnumMapping = new HashMap<String, DonorGender>();

		// Iterate through all RequestStatus enum constants and populate the mapping
		for (DonorGender gender : DonorGender.values()) {
			valueToEnumMapping.put(gender.getValue(), gender);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);
	}
}