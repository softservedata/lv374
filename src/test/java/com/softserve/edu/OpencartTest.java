package com.softserve.edu;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class OpencartTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\juliaa_sha\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://taqc-opencart.epizy.com/");
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            driver.get("http://taqc-opencart.epizy.com/");
        }
    }

    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test check if user can be registered
     * with empty fields.
     */
    @Test
    public void checkIfCanRegisterWithNoDataEntered() throws InterruptedException {

        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        driver.findElement(By.cssSelector("a[href*='register']")).click();

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'text-danger')]")).getText()
                ,"First Name must be between 1 and 32 characters!", "My_Error");


    }
    public Select getSelect(String parameter){
        Select select = new Select(driver.findElement(By.cssSelector(parameter)));
        return select;
    }
    /**
     * Positive test.
     * Used technique: Decision Tables.
     * This test check if user can be registered
     * with valid data entered in all fields.
     */
    @Test
    public void checkIfUserCanBeRegisteredWithValidDataEntered(){

        driver.findElement(By.cssSelector(".fa.fa-user")).click();

        driver.findElement(By.cssSelector("a[href*='register']")).click();

        //Enter first name
        driver.findElement(By.cssSelector("#input-firstname")).click();
        driver.findElement(By.cssSelector("#input-firstname")).clear();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Anna");

        //Enter last name
        driver.findElement(By.cssSelector("#input-lastname")).click();
        driver.findElement(By.cssSelector("#input-lastname")).clear();
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Smith");

        //Enter email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys("Smith@gmail.com");

        //Enter telephone
        driver.findElement(By.cssSelector("#input-telephone")).click();
        driver.findElement(By.cssSelector("#input-telephone")).clear();
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("+380 (98) 123 45 67");

        //Enter fax
        driver.findElement(By.cssSelector("#input-fax")).click();
        driver.findElement(By.cssSelector("#input-fax")).clear();
        driver.findElement(By.cssSelector("#input-fax")).sendKeys("11-22-33");

        //Enter company
        driver.findElement(By.cssSelector("#input-company")).click();
        driver.findElement(By.cssSelector("#input-company")).clear();
        driver.findElement(By.cssSelector("#input-company")).sendKeys("SoftServe");

        //Enter address 1
        driver.findElement(By.cssSelector("#input-address-1")).click();
        driver.findElement(By.cssSelector("#input-address-1")).clear();
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("SoftServe");

        //Enter address 2
        driver.findElement(By.cssSelector("#input-address-2")).click();
        driver.findElement(By.cssSelector("#input-address-2")).clear();
        driver.findElement(By.cssSelector("#input-address-2")).sendKeys("SoftServe 2");

        //Enter city
        driver.findElement(By.cssSelector("#input-city")).click();
        driver.findElement(By.cssSelector("#input-city")).clear();
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Lviv");

        //Enter post code
        driver.findElement(By.cssSelector("#input-postcode")).click();
        driver.findElement(By.cssSelector("#input-postcode")).clear();
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("79000");

        //Choose country
        driver.findElement(By.cssSelector("#input-country")).click();
        getSelect("#input-country").selectByVisibleText("Ukraine");

        //Choose region/state
        driver.findElement(By.cssSelector("#input-zone")).click();
        getSelect("#input-zone").selectByVisibleText("L'vivs'ka Oblast'");

        //Enter password
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("Ss*Jj&1*2#3");

        //Enter password confirm
        driver.findElement(By.cssSelector("#input-confirm")).click();
        driver.findElement(By.cssSelector("#input-confirm")).clear();
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Ss*Jj&1*2#3");

        //Test is not full, need to write couple more steps
    }

}
