package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.shop.SearchResultComponent.SelectInputLimit;
import com.softserve.edu.opencart.pages.shop.SearchResultComponent.SelectInputSort;

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

}
