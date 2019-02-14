package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartProductComponent extends CartProductContainer {
	public CartProductComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = ".//td[@class='text-center']/a/img")
	private WebElement cartProductImg;

	@FindBy(how = How.XPATH, using = ".//td[@class='text-left']/a")
	private WebElement cartProductName;

	@FindBy(how = How.XPATH, using = ".//td[@class='text-right' and contains(text(), 'x')]")
	private WebElement cartProductQuantity;

	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu pull-right']/li[1]/table/tbody/tr/td[@class='text-right' and contains(text(), '$')]")
	private WebElement cartProductPrice;

	@FindBy(how = How.XPATH, using = ".//td[@class='text-center']/button")
	private WebElement removeButton;

	@FindBy(how = How.XPATH, using = ".//p[@class='text-right']/a[1]")
	private WebElement viewCartButton;

	@FindBy(how = How.XPATH, using = ".//p[@class='text-right']/a[2]")
	private WebElement checkoutButton;

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
