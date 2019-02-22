package com.softserve.edu.mailbox.pages.boxes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.mailbox.pages.MailNavigationUnit;

public class IncomesLettersPage extends MailNavigationUnit {

	List<WebElement>letters;
	
	public IncomesLettersPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		
	}

}
