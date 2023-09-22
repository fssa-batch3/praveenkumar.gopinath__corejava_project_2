package com.fssa.savinglives.model;

public class User {


	/**
	 * Attributes for the User
	 */
	private int id;
	private String name;
	private String email;
	private String password;

	/**
	 * constructor for registration
	 * 
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	/**
	 * constructor for login
	 * 
	 * @param email
	 * @param password
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * Constructor after logged in
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * default constructor
	 */
	public User() {

	}

	/**
	 * Getter and setter for the attributes
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * toString method for the user
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [ name = " + name + ", email = " + email + ", password = " + password + " ]";
	}

}