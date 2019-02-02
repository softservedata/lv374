package com.softserve.edu.opencart.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeadUnit {
	
	protected WebDriver driver;
	//
	private WebElement logo;
	private WebElement searchField;
	private WebElement searchButton;
	
	protected HeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
		//
		//searchField = driver.findElement(By.name("search"));
		//searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		//logo = driver.findElement(By.cssSelector("#logo img"));
	}
	
	private void initElements() {
		searchField = driver.findElement(By.name("search"));
		searchButton = driver.findElement(By.cssSelector(".btn.btn-default.btn-lg"));
		logo = driver.findElement(By.cssSelector("#logo img"));
	}

	// Page Object

	// Functional

	// Business Logic
}
