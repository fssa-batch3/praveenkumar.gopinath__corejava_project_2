package savinglives.model;

public class Request {
	
	public String title;
	public String desc;
	public String blood_group;
	public String date;
	public String number;

	public Request(String title,String desc,String blood_group,String date,String number) {
		this.title = title;
		this.desc = desc;
		this.blood_group =  blood_group;
		this.date = date;
		this.number = number;
	}
	
	public void settitle(String title) {
		this.title=title;
	}
	
	public void setdesc(String desc) {
		this.desc = desc;
	}
	
	public void setblood_group(String blood_group) {
		this.blood_group = blood_group;
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
	
	public String getblood_group() {
		return blood_group;
	}
	
	public String getdate() {
		return date;
	}

	
	public String getnumber() {
		return number;
	}

	public boolean createrequest(Request request) {
		// TODO Auto-generated method stub
		return false;
	}

}