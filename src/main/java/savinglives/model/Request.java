package savinglives.model;

public class Request {
	
	public String title;
	public String description;
	public String group;
	public String date;
	public String id;
	public String number;

	public Request(String title,String description,String group,String date,String id,String number) {
		this.title = title;
		this.description = description;
		this.group =  group;
		this.date = date;
		this.id = id;
		this.number = number;
	}
	
	public void settitle(String title) {
		this.title=title;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
	
	public void setgroup(String group) {
		this.group = group;
	}
	
	public void setdate(String date) {
		this.date = date;
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	public void setnumber(String number) {
		this.number = number;
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
	
	public String getdate() {
		return date;
	}

	public String getid() {
		return id;
	}
	
	public String getnumber() {
		return number;
	}

	public boolean createrequest(Request request) {
		// TODO Auto-generated method stub
		return false;
	}
}