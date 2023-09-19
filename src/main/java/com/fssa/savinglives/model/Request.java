package com.fssa.savinglives.model;

import java.time.LocalDate;

public class Request {

	private String name;
	private String address;
	private String title;
	private String description;
	private String bloodType;
	private LocalDate reqDate;
	private long contactNo;
	private boolean reqVerification;
	private int reqId;

	public Request(String name, String address, String title, String description, String bloodType, LocalDate reqDate,
			int contactNo, boolean reqVerification) {
		this.name = name;
		this.address = address;
		this.title = title;
		this.description = description;
		this.bloodType = bloodType;
		this.reqDate = reqDate;
		this.contactNo = contactNo;
		this.reqVerification = reqVerification;
		this.setReqId(reqId);

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

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public LocalDate getReqDate() {
		return reqDate;
	}

	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public boolean getVerification() {
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
				+ ", description=" + description + ", reqDate=" + reqDate + ", contactNo=" + contactNo
				+ ", reqVerification=" + reqVerification + "]";
	}

}
