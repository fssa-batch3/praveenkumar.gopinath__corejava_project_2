package com.fssa.savinglives.model;

/**
 * Represents a user in the application.
 */
public class User {

	private String email;
	private int userid;
	private String username;
	private String password;

	/**
	 * Constructs a new User instance.
	 */
	public User() {
	}

	public User(String email, String username, String password,int userid) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.userid = userid;
	}

	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "Name='" + username + '\'' + ", Email='" + email + '\'' + ", Password='" + password + '\''
				+ ", Userid=" + userid + '}';
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

}