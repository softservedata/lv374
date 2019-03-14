package com.softserve.edu.rest.data;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String password;
	private String token;
	private List<Item> items;

	// TODO Develop Builder
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		items = new ArrayList<>();
	}

	// setters
	
	public User setToken(String token) {
		this.token = token;
		return this;
	}
	
	public User addItem(Item item) {
		items.add(item);
		return this;
	}

	// getters

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public List<Item> getItems() {
		return items;
	}

}
