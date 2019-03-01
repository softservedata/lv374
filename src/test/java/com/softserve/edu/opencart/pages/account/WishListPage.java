package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class WishListPage extends RightMenuUnit {

	private WishListContainer wishListContainer;
	private WebElement continueButton;

	public WishListPage(WebDriver driver) {
		super(driver);
		continueButton = driver.findElement(By.cssSelector(".pull-right > a"));
		wishListContainer = new WishListContainer(driver);
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public void clickContinueButton() {
		getContinueButton().click();
	}
	
	public boolean checkEmptyWishList() {
		if(getWishListContainer()
				.getWishListComponents()
				.isEmpty()) {
					return true;
		}		
		return false;
	}
	
	public WishListContainer getWishListContainer() {
		return wishListContainer;
	}
	
	public WishListPage chooseCurrency(Currencies currency){
		clickCurrencyByPartialName(currency);
		return new WishListPage(driver);
	}

	@Step("Get product price")
	public BigDecimal getWishListPriceByCurrency(Currencies currency, Product product){
		return chooseCurrency(currency).getWishListContainer().getWishListUnitPriceByProduct(product);
	}

	public String getWishListCurrencySymbol(Product product){
		return getWishListContainer().getCurrencyByProduct(product);
	}
	
	public MyAccountPage gotoMyAccount() {
		clickContinueButton();
		return new MyAccountPage(driver);
	}
	
	public WishListPage addToCart(Product product) {
		getWishListContainer().addToCartByName(product.getName());
		return new WishListPage(driver);
	}
	
	public WishListPage deleteFromWishList(Product product) {
		getWishListContainer().deleteButton(product.getName());
		return new WishListPage(driver);
	}
	
	public WishListPage emptyWishListPage() {
		checkEmptyWishList();
		return new WishListPage(driver);
	}

}
