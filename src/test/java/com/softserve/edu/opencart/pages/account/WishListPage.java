package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends RightMenuUnit {

	private WebElement wishListEmpty;
	private WebElement deleteButton;
	private WebElement addToCartButton;
	private WebElement productImage;
	private WebElement continueButton;

	public WishListPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		wishListEmpty = driver.findElement(By.xpath("//p[contains(text(), 'Your wish list is empty.')]"));
		continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary"));
	}

	// Page Object

	//wishListEmpty
	public WebElement getWishListEmpty() {
		return wishListEmpty;
	}

	public String getWishListEmptyText() {
		return getWishListEmpty().getText();
	}
	
	//deleteButton
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void clickDelete() {
		getDeleteButton().click();
	}

	//addToCartButton
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void clickAddToCart() {
		getAddToCartButton().click();
	}

	//productImage
	public WebElement getProductImage() {
		return productImage;
	}
	
	//continueButton
	public WebElement getContinueButton() {
		return continueButton;
	}
}
