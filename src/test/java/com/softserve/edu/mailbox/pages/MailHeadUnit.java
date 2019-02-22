package com.softserve.edu.mailbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MailHeadUnit {

	protected static final String ACTIVE_DROPDOWN_TABLE_CSS_SELECTOR = "a.login-button.active";

	protected WebDriver driver;

	private WebElement writeLetterButton;
	private WebElement searchField;
	private WebElement settingDropdown;

	public MailHeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		writeLetterButton = driver.findElement(By.cssSelector(".default.compose"));
		searchField = driver.findElement(By.xpath("//div[@class='search']//input"));
		settingDropdown = driver.findElement(By.cssSelector("a.login-button"));
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

	// setting dropdown

	public WebElement getSettingDropdown() {
		return settingDropdown;
	}

	public String getSettingDropdownText() {
		return getSettingDropdown().getText();
	}

	public void clickSettingDropdown() {
		getSettingDropdown().click();
	}

	// functional

	// business logic

	public DropdownSettingTable openSettings() {
		clickSettingDropdown();
		return new DropdownSettingTable(getSettingDropdown());
	}

	public class DropdownSettingTable {

		private WebElement element;

		public DropdownSettingTable(WebElement element) {
			this.element = element;
		}

		public WebElement getLogoutButton() {
			return element.findElement(By.id("login__logout"));
		}

		public void clickLogoutButton() {
			getLogoutButton().click();
		}

		public MailLoginPage logout() {
			clickLogoutButton();
			return new MailLoginPage(driver);
		}

	}

}
