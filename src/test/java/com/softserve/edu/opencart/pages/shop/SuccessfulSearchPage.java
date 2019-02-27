package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.shop.SearchResultComponent.SelectInputLimit;
import com.softserve.edu.opencart.pages.shop.SearchResultComponent.SelectInputSort;

import java.math.BigDecimal;

public class SuccessfulSearchPage extends SearchUnit {

	private SearchResultComponent searchResultComponent;
	
	public SuccessfulSearchPage(WebDriver driver) {
		super(driver);
		//
		searchResultComponent = new SearchResultComponent(driver);
	}

	// Page Object
	
	// searchResultComponent
	public SearchResultComponent getSearchResultComponent() {
		return searchResultComponent;
	}
	
	// Functional
	
	// Business Logic
	
	public SuccessfulSearchPage chooseProductAsList() {
		getSearchResultComponent().clickListView();
		return new SuccessfulSearchPage(driver);
	}

	public SuccessfulSearchPage chooseProductAsGrid() {
		getSearchResultComponent().clickGridView();
		return new SuccessfulSearchPage(driver);
	}

	public SuccessfulSearchPage chooseInputSortByVisibleText(SelectInputSort selectInputSort) {
		getSearchResultComponent().selectInputSortByVisibleText(selectInputSort);
		return new SuccessfulSearchPage(driver);
	}
	
	public SuccessfulSearchPage chooseInputLimitByVisibleText(SelectInputLimit selectInputLimit) {
		getSearchResultComponent().selectInputLimitByVisibleText(selectInputLimit);
		return new SuccessfulSearchPage(driver);
	}

	public BigDecimal getProductComponentPrice(Product product) {
		return getSearchResultComponent()
					.getProductComponentsContainer()
					.getProductComponentPriceByProduct(product);
	}

	public String getProductComponentDescription(Product product) {
		return getSearchResultComponent()
					.getProductComponentsContainer()
					.getProductComponentDescriptionByProduct(product);
	}

	public SuccessfulSearchPage chooseCurrency(Currencies currency) {
		clickCurrencyByPartialName(currency);
		return new SuccessfulSearchPage(driver);
	}

	public BigDecimal getPrice(Currencies currency, Product product){
		chooseCurrency(currency);
		return getProductComponentPrice(product);
	}

	public String getSuccessfulSearchCurrencySymbol(Product product){
		return getSearchResultComponent().getProductComponentsContainer().getCurrencyByProduct(product);
	}

}
