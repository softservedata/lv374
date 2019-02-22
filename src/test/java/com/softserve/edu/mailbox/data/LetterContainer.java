package com.softserve.edu.mailbox.data;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LetterContainer {

	private final static String PRODUCT_COMPONENT_XPATH_SELECTOR = "//div[@class='msglist']//tbody//tr";

	protected WebDriver driver;

	private List<LetterComponent> letters;

	public LetterContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		letters = new ArrayList<>();
		for (WebElement element : driver.findElements(By.xpath(PRODUCT_COMPONENT_XPATH_SELECTOR))) {
			letters.add(new LetterComponent(element));
		}
	}

	// page object

	// letters component
	
	public List<LetterComponent> getLetters(){
		return letters;
	}
	
	// functional
	
	public LetterComponent findLettterBy() {
		return null;
	}
	
}
