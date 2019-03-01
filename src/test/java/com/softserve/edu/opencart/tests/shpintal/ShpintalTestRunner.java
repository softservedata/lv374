package com.softserve.edu.opencart.tests.shpintal;

import com.softserve.edu.opencart.pages.shop.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class ShpintalTestRunner {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;

//    public void beforeClass() {
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\juliaa_sha\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        }

    @BeforeClass
    public void beforeClass() {
        URL url = this.getClass().getResource("/chromedriver.exe");
        if (url == null) {
            // TODO Log
            //System.exit(1);
            // TODO Develop Custom Exception
            throw new RuntimeException("ERROR: Chromedriver not Found");
        }
        System.setProperty("webdriver.chrome.driver",
                url.getPath());
        //this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        driver = new ChromeDriver();
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            // TODO Log
            // System.exit(1);
            // TODO Develop Custom Exception
            throw new RuntimeException("ERROR: Chromedriver not Found");
        }
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

    @Step("@Step: load HomePage")
    public HomePage loadApplication() {
        logger.debug("loadApplication() start");
        return new HomePage(driver);
    }
}
