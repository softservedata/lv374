package com.softserve.edu.ukrnet.data;

public class UserRepository {

	private UserRepository() {
	}
	
	public static User getValid() {
		return new User("opencart_test", "Lv374_taqc");
	}
	
}
