package com.fssa.savinglives.enums;

import java.util.HashMap;

public enum DonorDistrict {
	CHENNAI("Chennai"), COIMBATORE("Coimbatore"), MADURAI("Madurai"), SALEM("Salem"), TRICHY("Tiruchirapalli"),
	ERODE("Erode"), VELLORE("Vellore"), THANJAVUR("Thanjavur"), TIRUNELVELI("Tirunelveli"), TIRUPPUR("Tiruppur"),
	TUTICORIN("Thoothukudi"), KANCHIPURAM("Kanchipuram"), THIRUVALLUR("Thiruvallur"), NAMAKKAL("Namakkal"),
	VIRUDHUNAGAR("Virudhunagar"), DHARMAPURI("Dharmapuri"), CUDDALORE("Cuddalore"), KARUR("Karur"),
	RAMANATHAPURAM("Ramanathapuram"), SIVAGANGA("Sivaganga"), PERAMBALUR("Perambalur"), NILGIRIS("The Nilgiris"),
	ARIYALUR("Ariyalur");

	public final String value;

	DonorDistrict(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	};

	public static DonorDistrict valueToEnumMapping(String value) {
		HashMap<String, DonorDistrict> valueToEnumMapping = new HashMap<String, DonorDistrict>();

		for (DonorDistrict bloodGroup : DonorDistrict.values()) {
			valueToEnumMapping.put(bloodGroup.getValue(), bloodGroup);
		}

		return valueToEnumMapping.get(value);

	}
}