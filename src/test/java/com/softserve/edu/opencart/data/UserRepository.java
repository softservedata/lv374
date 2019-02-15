package com.softserve.edu.opencart.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getValid() {
		return new User("hahaha", "hahaha@gmail.com", "qwerty");
	}

	public static User getInvalid() {
		return new User("bebebe", "bebebe@gmail.com", "ytrewq");
	}

}
