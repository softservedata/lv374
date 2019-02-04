package com.softserve.edu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the currency change in shopping cart
 */
public class CurrencyInCart {

    private WebDriver driver;


    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/upload/");
        driver.findElement(By.cssSelector("a[href*='id=43']")).click();
        driver.findElement(By.cssSelector("#button-cart")).click();
        driver.findElement(By.cssSelector("a[title='Shopping Cart']")).click();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }

    /**
     * This test checks whether the currency is changing for a USD in shopping cart
     */
    @Test
    public void usdInCart() {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        char usd = driver.findElement(By.xpath("//td[@class='text-left']/div[@class='input-group btn-block']/.." +
                "/following-sibling::td[1]")).getText().charAt(0);
        Assert.assertEquals(usd, '$', "Not Equals");
    }

    /**
     * This test checks whether the currency is changing for a Euro in shopping cart
     */
    @Test
    public void euroInCart() {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        char euro = driver.findElement(By.xpath("//td[@class='text-left']/div[@class='input-group btn-block']/.." +
                "/following-sibling::td[1]")).getText().charAt(6);
        Assert.assertEquals(euro, '€', "Not Equals");
    }

    /**
     * This test checks whether the currency is changing for a Pound in shopping cart
     */
    @Test
    public void poundInCart() {
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        char pound = driver.findElement(By.xpath("//td[@class='text-left']/div[@class='input-group btn-block']/.." +
                "/following-sibling::td[1]")).getText().charAt(0);
        Assert.assertEquals(pound, '£', "Not Equals");
    }


}

