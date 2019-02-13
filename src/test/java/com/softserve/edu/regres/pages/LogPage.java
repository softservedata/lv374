package com.softserve.edu.regres.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.regres.data.User;

public class LogPage {
    public static final String NAME_IMAGE = "ukraine_logo2.gif";
    //
    public static final String SRC_ATTRIBUTE = "src";
	public static final String CLASS_ATTRIBUTE = "class"; 
    public static final String VALUE_ATTRIBUTE = "value"; 

    private WebDriver driver;
    //
    @FindBy(css = "div.col-md-7.col-xs-12")
    private WebElement titleMessage;
    //
    @FindBy(xpath = "//label[contains(@for,'inputEmail')]")
    private WebElement loginLabel;
    //
    //@CacheLookup
    @FindBy(id = "login")
    private WebElement loginInput;
    //
    @FindBy(xpath = "//label[contains(@for,'inputPassword')]")
    private WebElement passwordLabel;
    //
    //@CacheLookup
    @FindBy(id = "password")
    private WebElement passwordInput;
    //
    @FindBy(css = "button.btn.btn-primary")
    private WebElement signin;
    //
    @FindBy(css = "img.login_logo.col-md-8.col-xs-12")
    private WebElement logo;

    public LogPage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this); // 1st item
    }

	// Page Object

	// loginLabel
	public WebElement getLoginLabel() {
		return loginLabel;
	}

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	// loginInput
	public WebElement getLoginInput() {
		return loginInput;
	}

	public String getLoginInputAttributeText(String attribute) {
		return getLoginInput().getAttribute(attribute);
	}

	public String getLoginInputText() {
		return getLoginInputAttributeText(VALUE_ATTRIBUTE);
	}

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clickLoginInput() {
		getLoginInput().click();
	}

	// passwordLabel
	public WebElement getPasswordLabel() {
		return passwordLabel;
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	// passwordInput
	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public String getPasswordInputAttributeText(String attribute) {
		return getPasswordInput().getAttribute(attribute);
	}

	public String getPasswordInputText() {
		return getPasswordInputAttributeText(VALUE_ATTRIBUTE);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickPasswordInput() {
		getPasswordInput().click();
	}

	// signin
	public WebElement getSignin() {
		return signin;
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}

	public void clickSignin() {
		getSignin().click();
	}

	// logo
	public WebElement getLogo() {
		return logo;
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}
	
	// Functional
	
	private void setLoginData(User user) {
		setLoginInputClear(user.getLogin());
		setPasswordInputClear(user.getPassword());
		clickSignin();
	}
	
	// Business Logic
	public LogPage unsuccessfulLogin(User invalidUser) {
        setLoginData(invalidUser);
        return new LogPage(driver);
    }

}
