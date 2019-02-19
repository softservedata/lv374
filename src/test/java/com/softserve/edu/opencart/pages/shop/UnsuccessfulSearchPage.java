package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulSearchPage extends SearchUnit {

	private WebElement noProductLabel;
	
	public UnsuccessfulSearchPage(WebDriver driver) {
		super(driver);
		//
		noProductLabel = driver.findElement(By.cssSelector("#button-search + h2 + p"));
	}

	// Page Object
	
	// noProductLabel
	public WebElement getNoProductLabel() {
		return noProductLabel;
	}

	public String getNoProductLabelText() {
		return getNoProductLabel().getText();
	}
	// Functional
	
	// Business Logic

	public UnsuccessfulSearchPage chooseCurrency(Currencies currency) {
		clickCurrencyByPartialName(currency);
		return new UnsuccessfulSearchPage(driver);
	}

}
