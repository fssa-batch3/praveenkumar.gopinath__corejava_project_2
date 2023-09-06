package com.fssa.savinglives.model;

public class Blood {
	private String donor;
	private int age;
	private String bloodGroup;
	private String status;
	private String donatedDate;
	private User createdUser;
	
	public Blood(String donor, int age, String bloodGroup, String status, String donatedDate) {
		this.setDonor(donor);
		this.setAge(age);
		this.setBloodGroup(bloodGroup);
		this.setStatus(status);
		this.setDonatedDate(donatedDate);
	}
	public Blood(String donor, int age, String bloodGroup, String status, String donatedDate, User createdUser) {
		this.setDonor(donor);
		this.setAge(age);
		this.setBloodGroup(bloodGroup);
		this.setStatus(status);
		this.setDonatedDate(donatedDate);
	}

	public Blood() {
		
	}
	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDonatedDate() {
		return donatedDate;
	}

	public void setDonatedDate(String donatedDate) {
		this.donatedDate = donatedDate;
	}
	public User getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	public boolean delete(String donor2) {
		return false;
	}
}
