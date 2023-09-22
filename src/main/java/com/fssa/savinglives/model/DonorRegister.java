package com.fssa.savinglives.model;

import com.fssa.savinglives.enums.DonorBloodGroup;
import com.fssa.savinglives.enums.DonorDistrict;
import com.fssa.savinglives.enums.DonorGender;
import com.fssa.savinglives.enums.DonorState;

public class DonorRegister {
	private int userId;
	private String emailId;
	private String name;
	private int age;
	private DonorGender gender;
	private DonorBloodGroup bloodtype;
	private String address;

	private DonorState state;
	private DonorDistrict district;
	private String mobileNo;

	public DonorRegister(String emailId, String name, int age, DonorGender gender, DonorBloodGroup bloodtype,
			String address, DonorState state, DonorDistrict district, String mobileNo) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.bloodtype = bloodtype;
		this.address = address;
		this.state = state;
		this.district = district;
		this.age = age;
		this.emailId = emailId;
		this.gender = gender;

	}

	public DonorRegister() {

	}

	@Override
	public String toString() {
		return "DonorRequest [userId=" + userId + ", name=" + name + ", MobileNo=" + mobileNo + ", bloodtype="
				+ bloodtype + ", address=" + address + ", state=" + state + ", district=" + district + ", age=" + age
				+ ", emailId=" + emailId + ", gender=" + gender + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public DonorBloodGroup getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(DonorBloodGroup bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DonorState getState() {
		return state;
	}

	public void setState(DonorState state) {
		this.state = state;
	}

	public DonorDistrict getDistrict() {
		return district;
	}

	public void setDistrict(DonorDistrict district) {
		this.district = district;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public DonorGender getGender() {
		return gender;
	}

	public void setGender(DonorGender gender) {
		this.gender = gender;
	}

}
