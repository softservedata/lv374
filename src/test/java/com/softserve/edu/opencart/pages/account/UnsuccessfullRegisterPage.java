package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfullRegisterPage extends RegisterPage {

    public static final String EXPECTED_WARNING_PRIVACY_POLICY = "Warning: You must agree to the Privacy Policy!";
    public static final String EXPECTED_WARNING_EMAIL = "E-Mail Address does not appear to be valid!";

    public UnsuccessfullRegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private WebElement alertMessage;
   // private WebElement textDanger;

    private void initElements() {
        alertMessage = driver.findElement(By.cssSelector("div.alert.alert-danger"));
        //textDanger = driver.findElement(By.cssSelector(".text-danger"));
    }

    // Page Object

    // alertMessage
    public WebElement getAlertMessage() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger"));
    }

    public String getAlertMessageText(){
        return getAlertMessage().getText();
    }
    //textDanger
//    public WebElement getTextDanger() {
//        return textDanger;
//    }
//
//    public String getTextDangerText() {
//        return getTextDanger().getText();
//    }
    // Functional

    // Business Logic

}
