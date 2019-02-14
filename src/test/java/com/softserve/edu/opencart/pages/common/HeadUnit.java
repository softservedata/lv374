package com.softserve.edu.opencart.pages.common;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.LoggedMyAccount;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.UnloggedMyAccount;
import com.softserve.edu.opencart.pages.account.AccountLogoutPage;
import com.softserve.edu.opencart.pages.account.LoginPage;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;
import com.softserve.edu.opencart.pages.shop.UnsuccessfulSearchPage;

public abstract class HeadUnit {
	protected final String OPTION_NULL_MESSAGE = "DropdownOption is null";
	protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
	//
	protected final String TAG_ATTRIBUTE_VALUE = "value";
	protected final String TAG_ATTRIBUTE_SRC = "src";
	//
	protected final String LIST_CURENCIES_CSSSELECTOR = "div.btn-group.open ul.dropdown-menu li";
	protected final String DROPDOWN_MYACCOUNT_CSSSELECTOR = ".dropdown-menu-right li";
	
	protected WebDriver driver;
	//
	private WebElement currency;
	private WebElement myAccount;
	private WebElement wishList;
	private WebElement shoppingCart;
	private WebElement checkout;
	private WebElement logo;
	private WebElement searchField;
	private WebElement searchButton;
	private WebElement cartButton;
	//
	private DropdownComponent dropdownOptions;

	protected HeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
		//
		// searchField = driver.findElement(By.name("search"));
		// searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		// logo = driver.findElement(By.cssSelector("#logo img"));
	}

	private void initElements() {
		currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
		myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
		wishList = driver.findElement(By.id("wishlist-total"));
		shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
		checkout = driver.findElement(By.cssSelector("a[title='Checkout']"));
		searchField = driver.findElement(By.name("search"));
		searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		logo = driver.findElement(By.cssSelector("#logo img"));
		cartButton = driver.findElement(By.cssSelector("#cart > button"));
	}

	// Page Object

	// currency;
	public WebElement getCurrency() {
		return currency;
	}

	public String getCurrencyText() {
		return getCurrency().getText();
	}

	public void clickCurrency() {
		getCurrency().click();
	}

	// myAccount;
	public WebElement getMyAccount() {
		return myAccount;
	}

	public String getMyAccountText() {
		return getMyAccount().getText();
	}

	public void clickMyAccount() {
		getMyAccount().click();
	}

	// wishList;
	public WebElement getWishList() {
		return wishList;
	}

	public String getWishListText() {
		return getWishList().getText();
	}

	public void clickWishList() {
		getWishList().click();
	}

	// shoppingCart;
	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public String getShoppingCartText() {
		return getShoppingCart().getText();
	}

	public void clickShoppingCart() {
		getShoppingCart().click();
	}

	// checkout;
	public WebElement getCheckout() {
		return checkout;
	}

	public String getCheckoutText() {
		return getCheckout().getText();
	}

	public void clickCheckout() {
		getCheckout().click();
	}

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

	// cartButton
	public WebElement getCartButton() {
		return cartButton;
	}

	public String getCartButtonText() {
		return getCartButton().getText();
	}

	public void clickCartButton() {
		getCartButton().click();
	}

	// dropdownOptions
	protected DropdownComponent getDropdownOptions() {
		if (dropdownOptions == null) {
			// TODO Develop Custom Exception
			throw new RuntimeException(OPTION_NULL_MESSAGE);
		}
		return dropdownOptions;
	}

	private DropdownComponent createDropdownOptions(By searchLocator) {
		dropdownOptions = new DropdownComponent(driver, searchLocator);
		return getDropdownOptions();
	}

	private void clickDropdownOptionByPartialName(String optionName) {
		if (!getDropdownOptions().isExistDropdownOptionByPartialName(optionName)) {
			// TODO Develop Custom Exception
			throw new RuntimeException(String.format(OPTION_NOT_FOUND_MESSAGE, optionName,
					dropdownOptions.getListOptionsText().toString()));
		}
		getDropdownOptions().clickDropdownOptionByPartialName(optionName);
		dropdownOptions = null;
	}

	// Functional

	// currency
	protected void clickCurrencyByPartialName(Currencies optionName) {
		clickSearchProductField();
		clickCurrency();
		createDropdownOptions(By.cssSelector(LIST_CURENCIES_CSSSELECTOR));
		clickDropdownOptionByPartialName(optionName.toString());
	}

	// myAccount
	private void clickDropdownMyAccountByPartialName(String componentName) {
		clickSearchProductField();
		clickMyAccount();
		createDropdownOptions(By.cssSelector(DROPDOWN_MYACCOUNT_CSSSELECTOR));
		clickDropdownOptionByPartialName(componentName);
	}

	protected void clickUnloggedMyAccountByPartialName(UnloggedMyAccount optionName) {
		// TODO Check if Unlogged 
		clickDropdownMyAccountByPartialName(optionName.toString());
	}

	protected void clickLoggedMyAccountByPartialName(LoggedMyAccount optionName) {
		// TODO Check if loggined
		clickDropdownMyAccountByPartialName(optionName.toString());
	}

	// common
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

	public LoginPage gotoLogin() {
		clickUnloggedMyAccountByPartialName(UnloggedMyAccount.LOGIN);
		return new LoginPage(driver);	
	}
	
	public AccountLogoutPage gotoLogout() {
		clickLoggedMyAccountByPartialName(LoggedMyAccount.LOGOUT);
		return new AccountLogoutPage(driver);	
	}
}
