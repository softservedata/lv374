package com.softserve.edu.opencart.pages.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.tools.PriceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.shop.CartProductContainer;

public class WishListContainer {

	private static final String WISHLIST_COMPONENT_CSSSELECTOR = "table.table-hover > tbody > tr";

	protected WebDriver driver;

	private List<WishListComponent> wishlistComponents;

	public WishListContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		wishlistComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(WISHLIST_COMPONENT_CSSSELECTOR))) {
			wishlistComponents.add(new WishListComponent(current));
		}
	}

	// Page Object

	// wishlistComponents
	public List<WishListComponent> getWishListComponents() {
		return wishlistComponents;
	}

	
	//wishlistComponentByName
	public WishListComponent getWishListComponentByName(String productName) {
		WishListComponent result = null;
		for (WishListComponent current : getWishListComponents()) {
			if (current.getWishListProductNameText().toLowerCase().equals(productName.toLowerCase())) {
				result = current;
			}
		}
		if(result==null) {
			//TODO develop exception
			throw new RuntimeException("Product name: " + productName + "not found!");
		}
		return result;
	}
	
	public String getWishListProductByName(Product product) {
		return getWishListComponentByName(product.getName()).getWishListProductNameText();
	}
	
	//deleteButton
	public void deleteButton(String productName) {
		getWishListComponentByName(productName).clickDeleteButton();
	}
	
	//Business Logic
	
	public CartProductContainer addToCartByName(String productName) {
		getWishListComponentByName(productName).clickAddToCartButton();
		return new CartProductContainer(driver);
	}
	
	public WishListPage deleteButtonByName(String productName) {
		deleteButton(productName);
		return new WishListPage(driver);
	}

	public BigDecimal getWishListUnitPriceByProduct(Product product){
		return PriceUtils.getPrice(getWishListComponentByName(product.getName()).getWishlistUnitPriceText());
	}

	public String getCurrencyByProduct(Product product){
		return PriceUtils.getCurrencySymbol(getWishListComponentByName(product.getName()).getWishlistUnitPriceText());
	}


}
