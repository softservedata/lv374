package com.softserve.edu;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // @Test
    public void testApp() {
        Assert.assertTrue(true);
    }

    @Test
    public void testApp1() throws Exception {
        System.out.println("surefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
        System.out.println("selenium.version = " + System.getProperty("selenium.version"));
        System.out.println("System.getenv().database.password = " + System.getenv().get("DATABASE_PASSWORD"));
        System.out.println("System.getenv().database.password = " + System.getenv().get("IS_CONTINUES_INTEGRATION"));
    }

//	@DataProvider(parallel = true)
//	public Object[][] concurrencyData() {
//		return new Object[][] {
//			{ "1" },
//			{ "2" },
//		};
//	}

    // @Test//(dataProvider = "concurrencyData")
    public void checkSeleniumIDE() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        System.out.println("this.getClass().getResource(\"/chromedriver-windows-32bit.exe\").getPath() = "
                + this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("https://www.google.com");
        // driver.navigate().to("https://www.google.com");
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("selenium automation" + Keys.ENTER);
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.xpath("//h3[text()='Selenium - Web Browser Automation']/..")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        driver.findElement(By.linkText("Download")).click();
        Thread.sleep(1000); // For Presentation Only
        //
        String expected = "The Selenium Server is needed in order to run Remote Selenium WebDriver. Selenium 3.X is no longer capable of running Selenium RC directly, rather it does it through emulation and the WebDriverBackedSelenium interface.";
        String actual = driver
                .findElement(By.xpath("//h3[text()='Selenium Standalone Server']/following-sibling::p[1]")).getText();
        Assert.assertEquals(actual, expected, "My_Error");
        Thread.sleep(4000); // For Presentation Only
        //
        driver.quit();
    }

    //@Test
    public void checkMoveMouse() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        String path = this.getClass().getResource("/").getPath();
        path = "file://" + path.substring(0, path.indexOf("target")) + "JavaScriptPosition.html";
        System.out.println("path = " + path);
        driver.get(path);
        // driver.navigate().to("https://www.google.com");
        //
        Thread.sleep(1000); // For Presentation Only
        //
        //WebElement body = driver.findElement(By.tagName("body"));
        WebElement position = driver.findElement(By.id("testbutton"));
        Thread.sleep(1000); // For Presentation Only
        //
        // Move to Element by Action
        Actions action = new Actions(driver);
        //action.moveToElement(position, 2, 2).click().build().perform();
        //action.moveToElement(position).build().perform();
        //
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].focus();", position);
        //
        // Locate browser
        int heightBrowser = driver.manage().window().getSize().getHeight();
        int widthBrowser = driver.manage().window().getSize().getWidth();
        System.out.println("heightBrowser = " + heightBrowser);
        System.out.println("widthBrowser = " + widthBrowser);
        //
        long heightWindow = (long)js.executeScript("return window.innerHeight;");
        long widthWindow = (long)js.executeScript("return window.innerWidth;");
        System.out.println("heightWindow = " + heightWindow);
        System.out.println("widthWindow = " + widthWindow);
        //
        int xBrowser = driver.manage().window().getPosition().getX();
        int yBrowser = driver.manage().window().getPosition().getY();
        System.out.println("xBrowser = " + xBrowser);
        System.out.println("yBrowser = " + yBrowser);
        //
        // Locate body element
        //int xBody = body.getLocation().getX();
        //int yBody = body.getLocation().getY();
        //System.out.println("xBody = " + xBody);
        //System.out.println("yBody = " + yBody);
        //
        // Locate position element
        int xElement = position.getLocation().getX();
        int yElement = position.getLocation().getY();
        System.out.println("xElement = " + xElement);
        System.out.println("yElement = " + yElement);
        //
        Robot robot = new Robot();
        //robot.mouseMove(xBrowser + xElement + 20,
        //        yBrowser + yElement + 130);
        robot.mouseMove(xBrowser + xElement + (widthBrowser - (int)widthWindow),
                yBrowser + yElement + (heightBrowser - (int)heightWindow));
        //
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //
        Thread.sleep(4000); // For Presentation Only
        //
        //driver.quit();
    }

}
