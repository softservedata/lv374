package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.data.IUser;

public class RegisterPage extends RightLogoutUnit {

	public RegisterPage(WebDriver driver) {
		super(driver);
		checkElements();
	}

	private void checkElements() {
		getFirstname();
		getLastname();
		getEmail();
		getTelephone();
		getFax();
		getCompany();
		getAddress1();
		getAddress2();
		getCity();
		getPostcode();
		getCountry();
		getRegion();
		getPassword();
		getConfirmPassword();
		getSubscribeYes();
		getSubscribeNo();
		getPrivacyPolicy();

	}
	// Page Object

	// firstname
	public WebElement getFirstname() {
		return driver.findElement(By.cssSelector("#input-firstname"));
	}

	public String getFirstnameText() {
		return getFirstname().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setFirstnameField(String text) {
		getFirstname().sendKeys(text);
	}

	public void clearFirstname() {
		getFirstname().clear();
	}

	public void clickFirstname() {
		getFirstname().click();
	}

	// lastname
	public WebElement getLastname() {
		return driver.findElement(By.cssSelector("#input-lastname"));
	}

	public String getLastnameText() {
		return getLastname().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setLastnameField(String text) {
		getLastname().sendKeys(text);
	}

	public void clearLastname() {
		getLastname().clear();
	}

	public void clickLastname() {
		getLastname().click();
	}

	// email
	public WebElement getEmail() {
		return driver.findElement(By.cssSelector("#input-email"));
	}

	public String getEmailText() {
		return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setEmailField(String text) {
		getEmail().sendKeys(text);
	}

	public void clearEmail() {
		getEmail().clear();
	}

	public void clickEmail() {
		getEmail().click();
	}

	// telephone
	public WebElement getTelephone() {
		return driver.findElement(By.cssSelector("#input-telephone"));
	}

	public String getTelephoneText() {
		return getTelephone().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setTelephoneField(String text) {
		getTelephone().sendKeys(text);
	}

	public void clearTelephone() {
		getTelephone().clear();
	}

	public void clickTelephone() {
		getTelephone().click();
	}

	// fax
	public WebElement getFax() {
		return driver.findElement(By.cssSelector("#input-fax"));
	}

	public String getFaxText() {
		return getFax().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setFaxField(String text) {
		getFax().sendKeys(text);
	}

	public void clearFax() {
		getFax().clear();
	}

	public void clickFax() {
		getFax().click();
	}

	// company
	public WebElement getCompany() {
		return driver.findElement(By.cssSelector("#input-company"));
	}

	public String getCompanyText() {
		return getCompany().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setCompanyField(String text) {
		getCompany().sendKeys(text);
	}

	public void clearCompany() {
		getCompany().clear();
	}

	public void clickCompany() {
		getCompany().click();
	}

	// address1
	public WebElement getAddress1() {
		return driver.findElement(By.cssSelector("#input-address-1"));
	}

	public String getAddress1Text() {
		return getAddress1().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setAddress1Field(String text) {
		getAddress1().sendKeys(text);
	}

	public void clearAddress1() {
		getAddress1().clear();
	}

	public void clickAddress1() {
		getAddress1().click();
	}

	// address2
	public WebElement getAddress2() {
		return driver.findElement(By.cssSelector("#input-address-2"));
	}

	public String getAddress2Text() {
		return getAddress2().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setAddress2Field(String text) {
		getAddress2().sendKeys(text);
	}

	public void clearAddress2() {
		getAddress2().clear();
	}

	public void clickAddress2() {
		getAddress2().click();
	}

	// city
	public WebElement getCity() {
		return driver.findElement(By.cssSelector("#input-city"));
	}

	public String getCityText() {
		return getCity().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setCityField(String text) {
		getCity().sendKeys(text);
	}

	public void clearCity() {
		getCity().clear();
	}

	public void clickCity() {
		getCity().click();
	}

	// postcode
	public WebElement getPostcode() {
		// return postCodeInput;
		return driver.findElement(By.cssSelector("#input-postcode"));
	}

	public String getPostcodeText() {
		return getPostcode().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setPostcodeField(String text) {
		getPostcode().sendKeys(text);
	}

	public void clearPostcode() {
		getPostcode().clear();
	}

	public void clickPostcode() {
		getPostcode().click();
	}

	// country
	public Select getCountry() {
		return new Select(driver.findElement(By.id("input-country")));
	}

	public WebElement getCountryAsWebElement() {
		return getCountry().getWrappedElement();
	}

	public WebElement getCountrySelected() {
		return getCountry().getFirstSelectedOption();
	}

	public String getCountrySelectedText() {
		return getCountrySelected().getText().trim();
	}

	public void clickCountry() {
		getCountryAsWebElement().click();
	}

	protected void setCountry(String text) {
		getCountry().selectByVisibleText(text);
	}

	// region
	public Select getRegion() {
		return new Select(driver.findElement(By.id("input-zone")));
	}

	public WebElement getRegionAsWebElement() {
		return getRegion().getWrappedElement();
	}

	public WebElement getRegionSelected() {
		return getRegion().getFirstSelectedOption();
	}

	public String getRegionSelectedText() {
		return getRegionSelected().getText().trim();
	}

	public void clickRegion() {
		getRegionAsWebElement().click();
	}

	protected void setRegion(String text) {
		getRegion().selectByVisibleText(text);
	}

	// password
	public WebElement getPassword() {
		return driver.findElement(By.cssSelector("#input-password"));
	}

	public String getPasswordText() {
		return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setPasswordField(String text) {
		getPassword().sendKeys(text);
	}

	public void clearPassword() {
		getPassword().clear();
	}

	public void clickPassword() {
		getPassword().click();
	}

	// confirmPassword
	public WebElement getConfirmPassword() {
		return driver.findElement(By.cssSelector("#input-confirm"));

	}

	public String getConfirmPasswordText() {
		return getConfirmPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setConfirmPasswordField(String text) {
		getConfirmPassword().sendKeys(text);
	}

	public void clearConfirmPassword() {
		getConfirmPassword().clear();
	}

	public void clickConfirmPassword() {
		getConfirmPassword().click();
	}

	// subscribeYes
	public WebElement getSubscribeYes() {
		return driver.findElement(By.cssSelector("label.radio-inline > input[value='1']"));
	}

	public void clickSubscribeYes() {
		getSubscribeYes().click();
	}

	// subscribeNo
	public WebElement getSubscribeNo() {
		return driver.findElement(By.cssSelector("label.radio-inline > input[value='0']"));
	}

	public void clickSubscribeNo() {
		getSubscribeNo().click();
	}

	// privacyPolicy
	public WebElement getPrivacyPolicy() {
		return driver.findElement(By.name("agree"));
	}

	public void clickPrivacyPolicy() {
		getPrivacyPolicy().click();
	}

	// continueButton
	public WebElement getContinueButton() {
		return driver.findElement(By.cssSelector("input.btn.btn-primary"));
	}

	public String getContinueButtonText() {
		return getContinueButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	// Functional
	private void fillRegistrationForm(IUser user) {
		clickFirstname();
		clearFirstname();
		setFirstnameField(user.getFirstname());
		//
		clickLastname();
		clearLastname();
		setLastnameField(user.getLastname());
		//
		clickEmail();
		clearEmail();
		setEmailField(user.getEmail());
		//
		clickTelephone();
		clearTelephone();
		setTelephoneField(user.getTelephone());
		//
		clickFax();
		clearFax();
		setFaxField(user.getFax());
		//
		clickCompany();
		clearCompany();
		setCompanyField(user.getCompany());
		//
		clickAddress1();
		clearAddress1();
		setAddress1Field(user.getAddress1());
		//
		clickAddress2();
		clearAddress2();
		setAddress2Field(user.getAddress2());
		//
		clickCity();
		clearCity();
		setCityField(user.getCity());
		//
		clickPostcode();
		clearPostcode();
		setPostcodeField(user.getPostcode());
		//
		clickCountry();
		setCountry(user.getCountry().getField());
		//
		clickRegion();
		setRegion(user.getRegion().getName());
		//
		clickPassword();
		clearPassword();
		setPasswordField(user.getPassword());
		//
		clickConfirmPassword();
		clearConfirmPassword();
		setConfirmPasswordField(user.getPassword());
		//
		if (user.isSubscribe()) {
			clickSubscribeYes();
		} else {
			clickSubscribeNo();
		}
		//
		clickPrivacyPolicy();
		//
		clickContinueButton();
	}

	// Business Logic
	public SuccessRegisterPage successfullRegisterUser(IUser newValidUser) {
		fillRegistrationForm(newValidUser);
		return new SuccessRegisterPage(driver);
	}
}
