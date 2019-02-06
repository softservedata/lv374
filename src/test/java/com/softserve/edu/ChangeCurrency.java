package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the currency change on product page
 */
public class ChangeCurrency {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get("http://localhost/opencart/upload/");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href*='id=43']")).click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void afterTest(){
        driver.quit();
    }

    /**
     * This test checks whether the currency is changing for a USD on the product page
     */
    @Test
    public void forUSDTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(0);
        Assert.assertEquals(actual,'$',"NotEquals");

    }

    /**
     * This test checks whether the currency is changing for a Euro on the product page
     */
    @Test
    public void forEuroTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(6);
        Assert.assertEquals(actual,'€',"NotEquals");

    }

    /**
     * This test checks whether the currency is changing for a Pound on the product page
     */
    @Test
    public void forPoundTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        char actual = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText().charAt(0);
        Assert.assertEquals(actual,'£',"NotEquals");


    }

}
