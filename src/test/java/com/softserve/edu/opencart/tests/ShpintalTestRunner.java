package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.shop.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ShpintalTestRunner {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\juliaa_sha\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://localhost/index.php");
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            driver.get("http://localhost/index.php?route=account/logout");
        }
    }

    public HomePage loadApplication() {
        return new HomePage(driver);
    }
}
