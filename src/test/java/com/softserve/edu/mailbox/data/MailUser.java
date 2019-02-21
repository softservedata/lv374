package com.softserve.edu.mailbox.data;

public class MailUser {

	private String username;
	
	private String password;

	private MailUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static MailUser getValidUser() {
		return new MailUser("opencart_test", "Lv374_taqc");
	}
	
	public static MailUser getInvalidUser() {
		return new MailUser("qwe", "qwe");
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
	
}
