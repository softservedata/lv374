package com.softserve.edu.mailbox.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LetterComponent {

	private WebElement letterLayout;
	
	protected LetterComponent(WebElement leterLayout) {
		this.letterLayout = leterLayout;
	}
	
	public WebElement getLetterCheckBox() {
		return letterLayout.findElement(By.xpath("//tr//td//label"));
	}
	
	public boolean isLetterCheckBoxChecked() {
		return getLetterCheckBox().isSelected();
	}
	
	public void clickLetterCheckbox() {
		getLetterCheckBox().click();
	}
	
	public WebElement getReadStatusMark() {
		return letterLayout.findElement(By.xpath("//tr//td[2]//span"));
	}

	public boolean isLetterRead() {
		return getReadStatusMark().isSelected();
	}
	
	public void clickLetterStatusMark() {
		getReadStatusMark().click();
	}
	
	public WebElement getLetterAuthor() {
		return letterLayout.findElement(By.cssSelector("span.msglist__row-address-wrap"));
	}
	
	public String getLetterAuthorText() {
		return getLetterAuthor().getText();
	}
	
	public WebElement getLetterTitle() {
		return letterLayout.findElement(By.cssSelector("a.msglist__row_href"));
	}
	
	public String getLetterTitleText() {
		return getLetterTitle().getText();
	}
	
	public WebElement getLetterDate() {
		return letterLayout.findElement(By.cssSelector("td.msglist__row-date"));
	}
	
	public String getLetterDateText() {
		return getLetterDate().getAttribute("title");
	}
	
	
}
