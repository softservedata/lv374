package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends RightLogoutUnit {

    private WebElement firstname;
    private WebElement lastname;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;
    private WebElement company;
    private WebElement address1;
    private WebElement address2;
    private WebElement city;
    private WebElement postcode;
    private Select country;
    private Select region;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement subscribeYes;
    private WebElement subscribeNo;
    private WebElement privacyPolicy;
    private WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstname = driver.findElement(By.id("input-firstname"));
        lastname = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        telephone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));
        company = driver.findElement(By.id("input-company"));
        address1 = driver.findElement(By.id("input-address-1"));
        address2 = driver.findElement(By.id("input-address-2"));
        city = driver.findElement(By.id("input-city"));
        postcode = driver.findElement(By.id("input-postcode"));
        country = new Select(driver.findElement(By.id("input-country")));
        region = new Select(driver.findElement(By.id("input-zone")));
        password = driver.findElement(By.id("input-password"));
        confirmPassword = driver.findElement(By.id("input-confirm"));
        subscribeYes = driver.findElement(By.cssSelector("label.radio-inline > input[value='1']"));
        subscribeNo = driver.findElement(By.cssSelector("label.radio-inline > input[value='0']"));
        privacyPolicy = driver.findElement(By.name("agree"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

    // Page Object

    // firstname
    // lastname
    // email
    // telephone
    // fax
    // company
    // address1
    // address2
    // city
    // postcode
    // country
    // region
    // password
    // confirmPassword
    // subscribeYes
    // subscribeNo
    // privacyPolicy
    // continueButton

    // Functional

    // Business Logic

    public RegisterPage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new RegisterPage(driver);
    }
}