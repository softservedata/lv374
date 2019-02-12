package com.softserve.edu.regres.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getExist() {
		return new User("work", "qwerty");
	}

	public static User getInvalid() {
		return new User("hahaha", "hahaha");
	}

}
