package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class WishListPage extends RightMenuUnit {

	private WishListContainer wishListContainer;
	private WebElement continueButton;
	public static final Logger logger = LoggerFactory.getLogger(WishListPage.class);

	public WishListPage(WebDriver driver) {
		super(driver);
		continueButton = driver.findElement(By.cssSelector(".pull-right > a"));
		wishListContainer = new WishListContainer(driver);
	}
	
	//Page Object
	
	//continueButton
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public void clickContinueButton() {
		getContinueButton().click();
	}
	
	//wishListContainer
	public WishListContainer getWishListContainer() {
		return wishListContainer;
	}
	
	//Functional
	
	public boolean checkEmptyWishList() {
		if(getWishListContainer()
				.getWishListComponents()
				.isEmpty()) {
					return true;
		}		
		return false;
	}
	
	//Business Logic
	
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
	
	@Step("Add product to Cart")
	public WishListPage addToCart(Product product) {
		getWishListContainer().addToCartByName(product.getName());
		logger.info("Product added to cart");
		return new WishListPage(driver);
	}
	
	public WishListPage deleteFromWishList(Product product) {
		getWishListContainer().deleteButton(product.getName());
		logger.info("Product deleted frow wish list");
		return new WishListPage(driver);
	}
	
	public WishListPage emptyWishListPage() {
		checkEmptyWishList();
		return new WishListPage(driver);
	}

}
