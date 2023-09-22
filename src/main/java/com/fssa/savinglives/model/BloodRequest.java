package com.fssa.savinglives.model;

import java.time.LocalDate;

import com.fssa.savinglives.enums.*;

public class BloodRequest {

	private String name;
	private String address;
	private String title;
	private String description;
	private BloodGroup bloodtype;
	private LocalDate reqDate;
	private String contactNo;
	private boolean reqVerification;
	private int reqId;

	public BloodRequest(String name, String address, String title, String description, BloodGroup bloodtype,
			LocalDate reqDate, String contactNo, boolean reqVerification) {
		this.name = name;
		this.address = address;
		this.title = title;
		this.description = description;
		this.bloodtype = bloodtype;
		this.reqDate = reqDate;
		this.contactNo = contactNo;
		this.reqVerification = reqVerification;
		this.setReqId(reqId);

	}

	public BloodRequest() {
		// default constraint for validateBloodGroupType from BloodReqValidator.
	}

	// Default for testing the blood request service success..
	public BloodRequest(String name, String address, String title, String description, BloodGroup bloodType, String contactNo,
			LocalDate parse, boolean reqVerification) {
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;

	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BloodGroup getBloodType() {
		return bloodtype;
	}

	public void setBloodType(BloodGroup bloodtype) {
		this.bloodtype = bloodtype;
	}

	public LocalDate getReqDate() {
		return reqDate;
	}
	
	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}

	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	
	public boolean getReqVerification() {
		return reqVerification;
	}

	public void setReqVerification(boolean reqVerification) {
		this.reqVerification = reqVerification;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	@Override
	public String toString() {
		return "BloodRequest [reqId=" + reqId + ", name=" + name + ", address=" + address + ", title=" + title
				+ ", description=" + description + ",bloodtype=" + bloodtype + ", reqDate=" + reqDate + ", contactNo="
				+ contactNo + ", reqVerification=" + reqVerification + "]";
	}

}
