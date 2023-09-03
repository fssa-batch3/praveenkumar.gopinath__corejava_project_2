package com.fssa.savinglives.model;



public class Request {
		
		public String title;
		public String desc;
		public String bloodGroup;
		public String date;
		public String number;

	    public Request(String title, String desc, String bloodGroup, String date, String number) {
	        this.title = title;
	        this.desc = desc;
	        this.bloodGroup = bloodGroup;
	        this.date = date;
	        this.number = number;
	    }


	public void settitle(String title) {
		this.title=title;
	}
	
	public void setdesc(String desc) {
		this.desc = desc;
	}
	
	public void setbloodgroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public void setdate(String date) {
		this.date = date;
	}
	
	
	public void setnumber(String number) {
		this.number = number;
	}
	
	
	
	public String gettitle() {
		return title;
	}
	
	public String getdesc() {
		return desc;
	}
	
	public String getbloodgroup() {
		return bloodGroup;
	}
	
	public String getdate() {
		return date;
	}

	
	public String getnumber() {
		return number;
	}


	public int getId() {
		return 0;
	}
}