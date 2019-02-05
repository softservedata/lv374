package com.softserve.edu.opencart.pages.shop;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResultComponent {

	public enum SelectInputSort {
		DEFAULT("Default"),
		NAME_AZ("Name (A - Z)"),
		NAME_ZA("Name (Z - A)"),
		PRICE_LOW_HIGH("Price (Low > High)"),
		PRICE_HIGH_LOW("Price (High > Low)"),
		RATING_HIGHEST("Rating (Highest)"),
		RATING_LOWEST("Rating (Lowest)"),
		MODEL_AZ("Model (A - Z)"),
		MODEL_ZA("Model (Z - A)");
		//
		private String name;

		private SelectInputSort(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public enum SelectInputLimit {
		FIFTEEN("15"),
		TWENTY_FIVE("25"),
		FIFTY("50"),
		SEVENTY_FIVE("75"),
		HUNDRED("100");
		//
		private String name;

		private SelectInputLimit(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private WebDriver driver;
	//
	private WebElement listView;
	private WebElement gridView;
	private Select inputSort;
	private Select inputLimit;
	//
	private List<ProductComponent> productComponents;
	
	public SearchResultComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
		initProductComponents();
	}

	private void initElements() {
		//byList = driver.findElement(By.cssSelector(".fa.fa-th-list"));
		listView = driver.findElement(By.id("list-view"));
		gridView = driver.findElement(By.id("grid-view"));
		inputSort = new Select(driver.findElement(By.id("input-sort")));
		inputLimit = new Select(driver.findElement(By.id("input-limit")));
	}

	private void initProductComponents() {
		productComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(".product-layout"))) {
			productComponents.add(new ProductComponent(current));
		}
	}

	// Page Object

	// listView
	public WebElement getListView() {
		return listView;
	}

	public void clickListView() {
		getListView().click();
	}

	// gridView
	public WebElement getGridView() {
		return gridView;
	}

	public void clickGridView() {
		getGridView().click();
	}

	// inputSort
	public Select getInputSortAsSelect() {
		return inputSort;
	}
	
	public WebElement getInputSort() {
		return inputSort.getWrappedElement();
	}

	public String getInputSortText() {
		return getInputSortAsSelect().getFirstSelectedOption().getText();
	}

	public void clickInputSort() {
		getInputSort().click();
	}

	private void selectInputSortByVisibleText(String text) {
		getInputSortAsSelect().selectByVisibleText(text);
	}

	// inputLimit
	public Select getInputLimitAsSelect() {
		return inputLimit;
	}

	public WebElement getInputLimit() {
		return getInputLimitAsSelect().getWrappedElement();
	}

	public String getInputLimitText() {
		return getInputLimitAsSelect().getFirstSelectedOption().getText();
	}

	public void clickInputLimit() {
		getInputLimit().click();
	}
	
	private void selectInputLimitByVisibleText(String text) {
		getInputLimitAsSelect().selectByVisibleText(text);
	}
	
	// productComponents
	public List<ProductComponent> getProductComponents() {
		return productComponents;
	}

	// Functional
	
	// inputSort
	public void selectInputSortByVisibleText(SelectInputSort selectInputSort) {
		selectInputSortByVisibleText(selectInputSort.toString());
	}

	// inputLimit
	public void selectInputLimitByVisibleText(SelectInputLimit selectInputLimit) {
		selectInputLimitByVisibleText(selectInputLimit.toString());
	}
	
	// productComponents
	public ProductComponent getProductComponentByName(String productName) {
		ProductComponent result = null;
		for (ProductComponent current : getProductComponents()) {
			if (current.getNameText().toLowerCase()
					.equals(productName.toLowerCase())) {
				result = current;
			}
		}
		if (result == null) {
			// TODO Develop Custom Exception 
			throw new RuntimeException("ProductName: " + productName + " not Found.");
		}
		return result;
	}
	
	public String getProductComponentPriceByName(String productName) {
		return getProductComponentByName(productName).getPriceText();
	}

	public void clickProductComponentAddToCartButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToCartButton();
	}

	public void clickProductComponentAddToWishButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToWishButton();
	}

	// Business Logic
}
