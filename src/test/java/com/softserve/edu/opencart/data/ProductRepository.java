package com.softserve.edu.opencart.data;

public final class ProductRepository {

	private ProductRepository() {
	}

	public static Product getMacBook() {
		return new Product("mac", "MacBook",
				"Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..",
				"500.00"); 
	}

	public static Product getIPhone() {
		return new Product("phone", "iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
				"101.00"); 
	}

	public static Product getInvalidProduct() {
		return new Product("ccc", "aaa",
				"bebebe",
				"o.00"); 
	}

}
