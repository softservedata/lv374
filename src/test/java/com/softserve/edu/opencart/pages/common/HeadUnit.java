package com.softserve.edu.opencart.pages.common;

import 	org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;
import com.softserve.edu.opencart.pages.shop.UnsuccessfulSearchPage;

public abstract class HeadUnit {
	protected final String TAG_ATTRIBUTE_VALUE = "value";
	protected final String TAG_ATTRIBUTE_SRC = "src";

	protected WebDriver driver;
	//
	private WebElement logo;
	private WebElement searchField;
	private WebElement searchButton;
	
	protected HeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
		//
		//searchField = driver.findElement(By.name("search"));
		//searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		//logo = driver.findElement(By.cssSelector("#logo img"));
	}
	
	private void initElements() {
		searchField = driver.findElement(By.name("search"));
		searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		logo = driver.findElement(By.cssSelector("#logo img"));
	}

	// Page Object

	// logo
	public WebElement getLogo() {
		return logo;
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(TAG_ATTRIBUTE_SRC);
	}

	public void clickLogo() {
		getLogo().click();
	}

	// searchField
	public WebElement getSearchField() {
		return searchField;
	}

	public String getSearchProductFieldText() {
		return getSearchField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setSearchProductField(String text) {
		getSearchField().sendKeys(text);
	}

	public void clearSearchProductField() {
		getSearchField().clear();
	}

	public void clickSearchProductField() {
		getSearchField().click();
	}

	// searchButton
	public WebElement getSearchButton() {
		return searchButton;
	}

	public void clickSearchButton() {
		getSearchButton().click();
	}
	
	// Functional
	
	public void searchText(String text) {
		clickSearchProductField();
		clearSearchProductField();
		setSearchProductField(text);
		clickSearchButton();
	}

	// Business Logic
	
	public SuccessfulSearchPage successfulSearch(String text) {
		searchText(text);
		return new SuccessfulSearchPage(driver);
	}

	public SuccessfulSearchPage successfulSearch(Product validProduct) {
		return successfulSearch(validProduct.getSearchText());
	}

	public UnsuccessfulSearchPage unsuccessfulSearch(String text) {
		searchText(text);
		return new UnsuccessfulSearchPage(driver);
	}

	public UnsuccessfulSearchPage unsuccessfulSearch(Product invalidProduct) {
		return unsuccessfulSearch(invalidProduct.getSearchText());
	}

	public HomePage gotoHomePage() {
		clickLogo();
		return new HomePage(driver);
	}
	
}
