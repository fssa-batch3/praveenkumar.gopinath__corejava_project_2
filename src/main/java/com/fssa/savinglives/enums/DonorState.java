package com.fssa.savinglives.enums;

import java.util.HashMap;

public enum DonorState {
	// Enum constants with their corresponding values
	ANDHRA_PRADESH("Andhra Pradesh"), ARUNACHAL_PRADESH("Arunachal Pradesh"), ASSAM("Assam"), BIHAR("Bihar"),
	CHHATTISGARH("Chhattisgarh"), GOA("Goa"), GUJARAT("Gujarat"), HARYANA("Haryana"),
	HIMACHAL_PRADESH("Himachal Pradesh"), JHARKHAND("Jharkhand"), KARNATAKA("Karnataka"), KERALA("Kerala"),
	MADHYA_PRADESH("Madhya Pradesh"), MAHARASHTRA("Maharashtra"), MANIPUR("Manipur"), MEGHALAYA("Meghalaya"),
	MIZORAM("Mizoram"), NAGALAND("Nagaland"), ODISHA("Odisha"), PUNJAB("Punjab"), RAJASTHAN("Rajasthan"),
	SIKKIM("Sikkim"), TAMIL_NADU("Tamil Nadu"), TELANGANA("Telangana"), TRIPURA("Tripura"),
	UTTAR_PRADESH("Uttar Pradesh"), UTTARAKHAND("Uttarakhand"), WEST_BENGAL("West Bengal");

	// Property to store the value of each enum constant
	public final String value;

	// Constructor to initialize the enum constants with values
	DonorState(String value) {
		this.value = value;
	}

	// Getter method to retrieve the value of the enum constant
	public String getValue() {
		return value;
	}

	// Static method to map a string value to the corresponding enum constant
	public static DonorState valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, DonorState> valueToEnumMapping = new HashMap<String, DonorState>();

		// Iterate through all IndianState enum constants and populate the mapping
		for (DonorState state : DonorState.values()) {
			valueToEnumMapping.put(state.getValue(), state);
		}

		// Return the enum constant corresponding to the provided value
		return valueToEnumMapping.get(value);
	}
}