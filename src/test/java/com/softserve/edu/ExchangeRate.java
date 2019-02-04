package com.softserve.edu;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the price of a product changes correctly with a currency change
 * on the product page
 */
public class ExchangeRate {

    private WebDriver driver;
    private double usd;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/upload/");
        driver.findElement(By.cssSelector("a[href*='id=43']")).click();
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        usd = Double.parseDouble(driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2"))
                .getText().substring(1));
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }


    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Euro
     * on the product page
     */
    @Test
    public void changeToEuro(){
        double expected = Precision.round(0.78460002 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        String priceEuro = driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2")).getText();
        double actual = Double.parseDouble(priceEuro.substring(0,priceEuro.length()-1));
        Assert.assertEquals(actual, expected, "Not equals");
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Pound
     * on the product page
     */
    @Test
    public void changeToPound(){
        double expected = Precision.round(0.61250001 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        double actual = Double.parseDouble(driver.findElement(By.xpath("//div[@class='col-sm-4']//ul[@class='list-unstyled']//h2"))
                .getText().substring(1));
        Assert.assertEquals(actual, expected, "Not equals");
    }

}
