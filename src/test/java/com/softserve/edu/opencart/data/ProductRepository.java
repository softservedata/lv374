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
		return new Product("Iphone", "iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
				"123.20");
	}

	public static Product getIPodNano() {
		return new Product("iPod", "iPod Nano",
				"Video in your pocket. Its the small iPod with one very big idea: video. The worlds most..",
				"122.00");
	}

	public static Product getIPodNanoShortDescription() {
		return new Product("iPod", "iPod Nano",
				"Its the small iPod with one very big idea: video. The worlds most",
				"122.00");
	}
	
	
	public static Product getInvalidProduct() {
		return new Product("Ipont", "Ipont",
				"bebebe",
				"0.00"); 
	}

}
