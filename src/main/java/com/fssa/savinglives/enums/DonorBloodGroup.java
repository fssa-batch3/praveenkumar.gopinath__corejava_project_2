package com.fssa.savinglives.enums;

import java.util.HashMap;

public enum DonorBloodGroup {
	// Enum constants with their corresponding values
		A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("B+"), B_NEGATIVE("B-"), AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"),
		O_POSITIVE("O+"), O_NEGATIVE("O-");

		// Property to store the value of each enum constant
		public final String value;

		// Constructor to initialize the enum constants with values
		DonorBloodGroup(String value) {
			this.value = value;
		}

		// Getter method to retrieve the value of the enum constant
		public String getValue() {
			return value;
		};

		// Static method to map a string value to the corresponding enum constant
		public static DonorBloodGroup valueToEnumMapping(String value) {
			// Create a mapping of values to enum constants using a HashMap
			HashMap<String, DonorBloodGroup> valueToEnumMapping = new HashMap<String, DonorBloodGroup>();

			// Iterate through all BloodGroup enum constants and populate the mapping
			for (DonorBloodGroup donorBloodGroup : DonorBloodGroup.values()) {
				valueToEnumMapping.put(donorBloodGroup.getValue(), donorBloodGroup);
			}

			// Return the enum constant corresponding to the provided value
			return valueToEnumMapping.get(value);

}
}