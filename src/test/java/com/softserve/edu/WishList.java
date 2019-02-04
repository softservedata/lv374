package com.softserve.edu;

import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the price of a product changes correctly with a currency change
 * In the wish-list with one product
 */
public class WishList {

    private WebDriver driver;
    private double usd;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/opencart/upload/");
        driver.get("http://localhost/opencart/upload/index.php?route=account/logout");
        driver.findElement(By.cssSelector(".fa.fa-user")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("Vovan@vovan.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("vovan" + Keys.ENTER);
        driver.findElement(By.cssSelector(".img-responsive")).click();
        driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='MacBook']/../../.." +
                "//button[@data-original-title='Add to Wish List']")).click();
        driver.navigate().refresh();
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        driver.findElement(By.id("wishlist-total")).click();
        usd = Double.parseDouble(driver.findElement(By.className("price")).getText().substring(1));
    }

    @AfterMethod
    public void afterTest(){
        driver.findElement(By.xpath("//a[contains(@href,'remove=43')]")).click();
        driver.quit();
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Euro
     * in wish-list with one product
     */
    @Test
    public void euro (){
        double expected = Precision.round(0.78460002 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        String price = driver.findElement(By.className("price")).getText();
        double actual = Double.parseDouble(price.substring(0,price.length()-1));
        Assert.assertEquals(actual, expected, "Not equals");
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Pound
     * in wish-list with one product
     */
    @Test
    public void pound (){
        double expected = Precision.round(0.61250001 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        String price = driver.findElement(By.className("price")).getText();
        double actual = Double.parseDouble(price.substring(1));
        Assert.assertEquals(actual, expected, "Not equals");
    }


}
