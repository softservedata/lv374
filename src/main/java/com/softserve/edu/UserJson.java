package com.softserve.edu;

public class UserJson {

	private int id;
	private String name;
	private transient String random;

	public UserJson() {
        id = -1;
        name = "empty";
        random = "empty";
    }

	public UserJson(int id, String name) {
        this.id = id;
        this.name = name;
        random = " default ";
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRandom() {
		return random;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	@Override
	public String toString() {
		return "UserJson [id=" + id
				+ ", name=" + name 
				+ ", random=" + random
				+ "]";
	}
	
}
