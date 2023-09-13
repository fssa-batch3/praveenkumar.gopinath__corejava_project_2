package com.fssa.savinglives.model;



import java.time.LocalDate;

public class Request {

	
	public String title;
	public String description;
	public String group;
	public LocalDate date;
	public long number;
	public String email;
	private int is_deleted;
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Request() {
		
	}
	public Request(String title, String description, String group, LocalDate date, long number, String email) {
		this.title = title;
		this.description = description;
		this.group = group;
		this.date = date;
		this.number = number;
		this.email = email;
	}
	
	public Request(String email) {
		this.email = email;
	}
	
	

	public void settitle(String title) {
		this.title = title;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public void setgroup(String group) {
		this.group = group;
	}

	public void setdate(LocalDate date) {
		this.date = date;
	}

	public void setnumber(long number) {
		this.number = number;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	
	public String gettitle() {
		return title;
	}

	public String getdescription() {
		return description;
	}

	public String getgroup() {
		return group;
	}

	public LocalDate getdate() {
		return date;
	}

	public long getnumber() {
		return number;
	}
	
	public String getemail() {
		return email;
	}
	public Request (String title, String description, String group, Long number) {
		super();
		this.title = title;
		this.description = description;
		this.group = group;
		this.number = number;
		
	}

	@Override
	public String toString() {
		return "Request [title=" + title + ", description=" + description + ", group=" + group + ", date=" + date
				+ ", number=" + number + ", email=\" + email +],";
	}



	
	}

	