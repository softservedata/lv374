package com.softserve.edu.opencart.pages.shop;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.common.HeadUnit;

public class CartProductContainer extends HeadUnit {
	private static final String CART_PRODUCT_COMPONENT_XPATH = (".//ul[@class='dropdown-menu pull-right']/li[1]/table/tbody/tr");

	private List<CartProductComponent> cartProductComponents;

	public CartProductContainer(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		cartProductComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.xpath(CART_PRODUCT_COMPONENT_XPATH))) {
	//		cartProductComponents.add(new CartProductComponent(current));
		}
	}

	// Page Object

	// cartProductComponents
	public List<CartProductComponent> getCartProductComponents() {
		return cartProductComponents;
	}

	// Functional

	// cartProductComponents
	public CartProductComponent getCartProductComponentByName(String cartProductName) {
		CartProductComponent result = null;
		for (CartProductComponent current : getCartProductComponents()) {
			if (current.getCartProductNameText().toLowerCase().equals(cartProductName.toLowerCase())) {
				result = current;
			}
		}
		if (result == null) {
			// TODO Develop Custom Exception
			throw new RuntimeException("ProductName: " + cartProductName + " not Found.");
		}
		return result;
	}
}
