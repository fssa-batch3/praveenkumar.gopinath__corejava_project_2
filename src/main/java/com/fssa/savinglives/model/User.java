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

	/**
	 * Constructs a new User instance with specified details.
	 *
	 * @param email    The email address of the user.
	 * @param username The userName of the user.
	 * @param password The password of the user.
	 */
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(String email, String username, String password, int userid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.userid = userid; 
		
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
				+ '}';
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

}