package com.fssa.savinglives.enums;

import java.util.HashMap;

public enum BloodGroup {
	A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("B+"), B_NEGATIVE("B-"), AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"),
	O_POSITIVE("O+"), O_NEGATIVE("O-");

	public final String value;

	BloodGroup(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	};

	public static BloodGroup valueToEnumMapping(String value) {
		// Create a mapping of values to enum constants using a HashMap
		HashMap<String, BloodGroup> valueToEnumMapping = new HashMap<String, BloodGroup>();

		for (BloodGroup bloodGroup : BloodGroup.values()) {
			valueToEnumMapping.put(bloodGroup.getValue(), bloodGroup);
		}

		return valueToEnumMapping.get(value);

	}
}