package com.softserve.edu.mailbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MailHeadUnit {

	protected static final String ACTIVE_DROPDOWN_TABLE_CSS_SELECTOR = "a.login-button.active";
	protected static final String LOGOUT_LINK = "https://mail.ukr.net/q/logout";

	protected WebDriver driver;

	private WebElement writeLetterButton;
	private WebElement searchField;

	public MailHeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		writeLetterButton = driver.findElement(By.cssSelector(".default.compose"));
		searchField = driver.findElement(By.xpath("//div[@class='search']//input"));
	}

	// page object

	// Write letter
	public WebElement getWriteLetterButton() {
		return writeLetterButton;
	}

	public String getWriteLetterButtonText() {
		return getWriteLetterButton().getText();
	}

	public void clickWriteLetterButton() {
		getWriteLetterButton().click();
	}

	// search field

	public WebElement getSearchField() {
		return searchField;
	}

	public String getSearchFieldText() {
		return getSearchField().getText();
	}

	public void clickSearchField() {
		getSearchField().click();
	}

	public void clearSearchField() {
		getSearchField().clear();
	}

	public void setSearchField(String text) {
		getSearchField().sendKeys(text);
	}

	// functional

	private void logoutFromMailBox() {
		driver.get(LOGOUT_LINK);
	}

	// business logic

	public MailLoginPage logout() {
		logoutFromMailBox();
		return new MailLoginPage(driver);
	}

}
