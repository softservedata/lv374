package com.softserve.edu.loginTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends SetingTest {

	/**
	 * send existing email in forgot password field
	 * 
	 * @throws Exception
	 */
	@Test
	public void existingEmailTest() throws Exception {
		forgotPasswordPage();
		String email = "opencart_test@ukr.net";
		inputData(getField("//input[contains(@name, 'email')]"), email + Keys.ENTER);
		List<String> tabs = openNewTab("https://mail.ukr.net/");
		inputData(getField("//input[contains(@id, 'id-l')]"), email);
		inputData(getField("//input[contains(@id, 'id-p')]"), "Lv374_taqc" + Keys.ENTER);
		findMail("//pre//a");
		newPass("qwerty");
		driver.close();
	}

	//check error
	private void newPass(String password) {
		inputData(getField("//input[contains(@id, 'input-password')]"), password);
		inputData(getField("//input[contains(@id, 'input-confirm')]"), password + Keys.ENTER);
	}

	private void findMail(String xpath) throws Exception {
		driver.findElement(By.xpath("//span[text()='Спам']")).click();
		// this should helps
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		int counter = 0; // optional, just to cut off infinite waiting
		while (element == null && counter != 10) {
			try {
				element = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//tr[@class='msglist__row unread icon0  ui-draggable']")));
				element.findElement(By.xpath("//td[@class='msglist__row-address']")).click();;
			} catch (Exception e) {
				driver.navigate().refresh();
				counter++;
			}
			if(counter >= 10) {
				throw new TimeoutException();
			}
		}
		driver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * send unexisting email in forgot password field
	 */
	@Test
	public void unexistingEmailTest() {
		forgotPasswordPage();
		String currentUrl = driver.getCurrentUrl();
		inputData(getField("//input[contains(@name, 'email')]"), "hugfdgfegper" + Keys.ENTER);
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
