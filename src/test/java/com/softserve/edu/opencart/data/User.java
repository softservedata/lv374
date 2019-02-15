package com.softserve.edu.opencart.data;

public class User {

	private String firstname;
	private String email;
	private String password;

	public User(String firstname, String email, String password) {
		this.firstname = firstname;
		this.email = email;
		this.password = password;
	}

	// setters
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// getters

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
