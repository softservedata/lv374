package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.common.NavigationUnit;

public abstract class SearchUnit extends NavigationUnit {

	private WebElement inputSearchField;
	private Select selectCategory;
	private WebElement subcategoriesSearchCheckBox;
	private WebElement productDescriptionsSearchCheckBox;
	private WebElement inputSearchButton;
	
	public SearchUnit(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		inputSearchField = driver.findElement(By.id("input-search"));
		selectCategory = new Select(driver.findElement(By.name("category_id")));
		subcategoriesSearchCheckBox = driver.findElement(By.name("sub_category"));
		productDescriptionsSearchCheckBox = driver.findElement(By.name("description"));
		inputSearchButton = driver.findElement(By.id("button-search"));
	}

	// Page Object
	
	// inputSearchField
//	public WebElement get***() {
//		return ***;
//	}
//
//	public String get***Text() {
//		return get***().getAttribute(TAG_ATTRIBUTE_VALUE);
//	}
//
//	public void set***Field(String text) {
//		get***().sendKeys(text);
//	}
//
//	public void clear***() {
//		get***().clear();
//	}
//
//	public void click***() {
//		get***().click();
//	}

	// selectCategory
	
	// subcategoriesSearchCheckBox
	
	// productDescriptionsSearchCheckBox
	
	// inputSearchButton

	// Functional
	
	// Business Logic
}
