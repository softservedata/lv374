package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.WebDriver;

public class WishListPage extends RightMenuUnit {

	private WishListContainer wishListContainer;
	
	public WishListPage(WebDriver driver) {
		super(driver);
		wishListContainer = new WishListContainer(driver);
	}

	public WishListContainer getWishListContainer() {
		return wishListContainer;
	}
}
