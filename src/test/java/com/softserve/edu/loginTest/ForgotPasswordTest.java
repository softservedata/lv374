package com.softserve.edu.loginTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends SetingTest {

	/**
	 * send existing email in forgot password field
	 */
	@Test
	public void existingEmailTest() {
		forgotPasswordPage();
		String email = "opencart_test@ukr.net";
		inputData(getField("//input[contains(@name, 'email')]"), email + Keys.ENTER);
//		List<String> tabs = openNewTab("https://mail.ukr.net/");
//		inputData(getField("//input[contains(@id, 'id-l')]"), email);
//		inputData(getField("//input[contains(@id, 'id-p')]"), "Lv374_taqc" + Keys.ENTER);
//		findMail("xpath");
	}

//	private void findMail(String xpath) {
//		// todo
//	}

	/**
	 * send unexisting email in forgot password field
	 */
	@Test
	public void unexistingEmailTest() {
		forgotPasswordPage();
		String currentUrl = driver.getCurrentUrl();
		inputData(getField("//input[contains(@name, 'email')]"), "huiregper" + Keys.ENTER);
		String newUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, newUrl);
	}

	/**
	 * method open inputed url in new tab
	 * 
	 * @param url url to be opened
	 * @return array list of all opened tabs
	 */
	public ArrayList<String> openNewTab(String url) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.get(url);
		return tabs;
	}

	/**
	 * open forgot password page
	 */
	private void forgotPasswordPage() {
		openLoginPage();
		driver.findElement(By.xpath("//a[text()='Forgotten Password']")).click();
	}

}
