package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;

import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class WishListPage extends RightMenuUnit {

	private WishListContainer wishListContainer;

	public WishListPage(WebDriver driver) {
		super(driver);
		wishListContainer = new WishListContainer(driver);
	}

	public WishListContainer getWishListContainer() {
		return wishListContainer;
	}

	public WishListPage chooseCurrency(Currencies currency){
		clickCurrencyByPartialName(currency);
		return new WishListPage(driver);
	}

	public BigDecimal getWishListPriceByCurrency(Currencies currency, Product product){
		return chooseCurrency(currency).getWishListContainer().getWishListUnitPriceByProduct(product);
	}

	public String getWishListCurrencySymbol(Product product){
		return getWishListContainer().getCurrencyByProduct(product);
	}
	
	public WishListPage addToCart(Product product) {
		getWishListContainer().addToCartByName(product.getName());
		return new WishListPage(driver);
	}
	
	public WishListPage deleteFromWishList(Product product) {
		getWishListContainer().deleteButton(product.getName());
		return new WishListPage(driver);
	}

}
