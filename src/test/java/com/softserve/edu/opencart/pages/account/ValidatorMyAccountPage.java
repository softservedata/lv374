package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.WebDriver;

public class ValidatorMyAccountPage extends MyAccountPage {

	public ValidatorMyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Page Object

	// Functional

	// Business Logic

	public ValidatorMyAccountPage chooseCurrency(Currencies currency) {
		clickCurrencyByPartialName(currency);
		return new ValidatorMyAccountPage(driver);
	}

}
