package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UnsuccessfullRegisterPageAlert extends RegisterPage {

    public static final String EXPECTED_WARNING_PRIVACY_POLICY = "Warning: You must agree to the Privacy Policy!";

    public UnsuccessfullRegisterPageAlert(WebDriver driver) {
        super(driver);
        checkElements();
    }

    private void checkElements() {
        getAlertMessage();
    }

    // Page Object

    public WebElement getAlertMessage() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger"));
    }

    public String getAlertMessageText() {
        return getAlertMessage().getText().trim();
    }
}
