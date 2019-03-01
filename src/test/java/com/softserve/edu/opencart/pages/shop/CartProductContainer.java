package com.softserve.edu.opencart.pages.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.tools.PriceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartProductContainer {
	private static final String PRODUCT_COMPONENT_CSSSELECTOR = (".table.table-striped>tbody>tr");
	private static final String PRICE_TABLE_CSSSELECTOR = (".dropdown-menu.pull-right .table.table-bordered");

	public static final Logger logger = LoggerFactory.getLogger(CartProductContainer.class);

	protected WebDriver driver;

	private List<CartProductComponent> productComponents;

	public CartProductContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		productComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
			productComponents.add(new CartProductComponent(current));
		}
	}

	// Page Object

	// productComponents
	public List<CartProductComponent> getCartProductComponents() {
		return productComponents;
	}

	// Functional

	// cartProductComponents
	public CartProductComponent getCartProductComponentByName(String productName) {
		CartProductComponent result = null;
		for (CartProductComponent current : getCartProductComponents()) {
			logger.debug("Product "+current.getCartProductNameText()+" added to list");
			if (current.getCartProductNameText().toLowerCase().equals(productName.toLowerCase())) {
				result = current;
			}
		}
		if (result == null) {
			throw new RuntimeException("ProductName: " + productName + " not Found.");
		}
		return result;
	}

	/**
	 * Search table with total price information at dropdown cart
	 * @return
	 */
	public TotalPriceTableComponent getTotalPriceTableComponent(){
		return new TotalPriceTableComponent(driver.findElement(By.cssSelector(PRICE_TABLE_CSSSELECTOR)));
	}

	public BigDecimal getCartProductPriceByName(String productName) {
		return PriceUtils.getPrice(getCartProductComponentByName(productName).getCartProductPriceText());
	}

	private void removeProductFromCartByName(String productName) {
		getCartProductComponentByName(productName).clickRemoveButton();
	}

	public HomePage removeProductByName(Product product) {
		removeProductFromCartByName(product.getName());
		return new HomePage(driver);
	}
}
