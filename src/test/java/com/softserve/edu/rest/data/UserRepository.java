package com.softserve.edu.rest.data;

public final class UserRepository {
	
	private UserRepository() {
	}

	public static User getAdmin() {
		return new User("admin", "qwerty");
	}
}
