package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartProductComponent extends CartProductContainer {
	private WebElement cartProductImg;
	private WebElement cartProductName;
	private WebElement cartProductQuantity;
	private WebElement cartProductPrice;
	private WebElement removeButton;
	private WebElement viewCartButton;
	private WebElement checkoutButton;

	public CartProductComponent(WebDriver driver) {
		super(driver);
		initElements();
	}
	private void initElements() {
		cartProductImg = driver.findElement(By.xpath(".//td[@class='text-center']/a/img"));
		cartProductName = driver.findElement(By.xpath(".//td[@class='text-left']/a"));
		cartProductQuantity = driver.findElement(By.xpath(".//td[@class='text-right' and contains(text(), 'x')]"));
		cartProductPrice = driver.findElement(By.xpath(
				"//ul[@class='dropdown-menu pull-right']/li[1]/table/tbody/tr/td[@class='text-right' and contains(text(), '$')]"));
		removeButton = driver.findElement(By.xpath(".//td[@class='text-center']/button"));
		viewCartButton = driver.findElement(By.xpath(".//p[@class='text-right']/a[1]"));
		checkoutButton = driver.findElement(By.xpath(".//p[@class='text-right']/a[2]"));
	}

	// cartProductImg
	public WebElement getCartProductImg() {
		return cartProductImg;
	}

	// cartProductName
	public WebElement getCartProductName() {
		return cartProductName;
	}

	public String getCartProductNameText() {
		return cartProductName.getText();
	}

	public void clickCartProductName() {
		getCartProductName().click();
	}

	// cartProductQuantity
	public WebElement getCartProductQuantity() {
		return cartProductQuantity;
	}

	public String getCartProductQuantityText() {
		return cartProductQuantity.getText();
	}

	// cartProductPrice
	public String getCartProductPriceText() {
		return cartProductPrice.getText();
	}

	public WebElement getCartProductPrice() {
		return cartProductPrice;
	}

	// removeButton
	public WebElement getRemoveButton() {
		return removeButton;
	}

	public void clickRemoveButton() {
		getRemoveButton().click();
	}

	// viewCartButton
	public WebElement getViewCartButton() {
		return viewCartButton;
	}

	public void clickViewCartButton() {
		getViewCartButton().click();
	}

	// checkoutButton
	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	public void clickCheckoutButton() {
		getCheckoutButton().click();
	}

	// Functional

	
	// Business Logic

}
