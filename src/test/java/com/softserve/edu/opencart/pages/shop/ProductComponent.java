package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {

	protected WebElement baseElement;
	//
	
	protected ProductComponent(WebElement baseElement) {
		this.baseElement = baseElement;
		initElements();
	}
	
	private void initElements() {
		//searchField = baseElement.findElement(By.name("search"));
	}
	
	// Page Object
	
	// Functional
	
	// Business Logic

}
