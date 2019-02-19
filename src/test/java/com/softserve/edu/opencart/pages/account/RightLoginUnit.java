package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.User;

public class RightLoginUnit extends RightMenuUnit {

	private WebElement editAccountBar;
	// passwordBar
	// logoutBar
	
	public RightLoginUnit(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		editAccountBar = driver.findElement(By.cssSelector("div.list-group > a[href*='route=account/edit']"));
	}

	// Page Object

	// editAccountBar
	public WebElement getEditAccountBar() {
		return editAccountBar;
	}

	public String getEditAccountBarText() {
		return getEditAccountBar().getText();
	}

	public void clickEditAccountBar() {
		getEditAccountBar().click();
	}
	
	// password
	// logout

	// Functional
	
	protected void loginUser(IUser user) {
	}
	
	// Business Logic
	
	public EditAccountPage gotoEditAccountPage() {
		clickEditAccountBar();
        return new EditAccountPage(driver);
    }

	public MyAccountPage gotoMyAccountPage() {
		clickMyAccount();
		return new MyAccountPage(driver);
	}

	public AddressBookPage gotoAddressBookPage() {
		clickAddressBookBar();
		return new AddressBookPage(driver);
	}

	public WishListPage gotoWishListPage() {
		clickWishListBar();
		return new WishListPage(driver);
	}

	public OrderHistoryPage gotoOrderHistoryPage() {
		clickOrderHistoryBar();
		return new OrderHistoryPage(driver);
	}

	public DownloadsPage gotoDownloadsPage() {
		clickDownloadsBar();
		return new DownloadsPage(driver);
	}

	public RecurringPaymentsPage gotoRecurringPaymentsPage() {
		clickRecurringpaymentsBar();
		return new RecurringPaymentsPage(driver);
	}

	public RewardPointsPage gotoRewardPointsPage() {
		clickRewardPointsBar();
		return new RewardPointsPage(driver);
	}

	public ReturnsPage gotoReturnsPage() {
		clickReturnsBar();
		return new ReturnsPage(driver);
	}

	public TransactionPage gotoTransactionPage() {
		clickTransactionsBar();
		return new TransactionPage(driver);
	}

	public NewsletterPage gotoNewsletterPage() {
		clickNewsletterBar();
		return new NewsletterPage(driver);
	}

}
