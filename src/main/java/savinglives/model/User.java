package savinglives.model;

public class User {
	private String username;
	private String email;
	private String password;
//	private String mobileNo;
//	private String gender;
//	private String address;

	// Constructor
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;

	}
	


	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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


	// toString method
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password
				+ ",]";
	}

}
