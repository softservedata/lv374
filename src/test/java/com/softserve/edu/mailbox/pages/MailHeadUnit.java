package com.softserve.edu.mailbox.pages;

import org.openqa.selenium.WebDriver;

public abstract class MailHeadUnit {

	protected WebDriver driver;
	
	public MailHeadUnit(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements() {
		
	}
	
}
