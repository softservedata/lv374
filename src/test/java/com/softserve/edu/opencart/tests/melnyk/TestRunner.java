package com.softserve.edu.opencart.tests.melnyk;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.shop.HomePage;

public class TestRunner {
	
	protected final String SERVER_URL = "http://127.0.1.1/opencart/upload/";

	protected WebDriver driver;
	
    @BeforeClass
    public void beforeClass() {
        URL url = this.getClass().getResource("/chromedriver-linux-64bit");
        if (url == null) {
            throw new RuntimeException("ERROR: Chromedriver not Found");
        }
        System.setProperty("webdriver.chrome.driver",
                url.getPath());
        driver = new ChromeDriver();
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
        	throw new RuntimeException("ERROR: Chromedriver not Found");
        }
    }
    
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(SERVER_URL);
	}
	
	public HomePage loadApplication() {
		return new HomePage(driver); 
	}

}
