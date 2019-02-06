package com.softserve.edu;

import com.softserve.util.AddProduct;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the price of a product changes correctly with a currency change
 * In the shopping cart when several products are added
 */
public class SeveralProductsInCart {

    private WebDriver driver;
    private double usd;
    private AddProduct addProduct = new AddProduct();

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.get("http://localhost/opencart/upload/");
        Thread.sleep(1000);
        addProduct.addProductToCart("//h4/a[text()='MacBook']", driver);
        Thread.sleep(1000);
        addProduct.addProductToCart("//h4/a[text()='iPhone']", driver);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cart-total")).click();
        Thread.sleep(1000);
        usd = Double.parseDouble(driver.findElement(By.xpath(
                "//td[strong='Total']/following-sibling::td")).getText().substring(1).replaceAll(",", ""));
    }

    @AfterClass
    public void afterTest(){
        driver.quit();
    }


    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Euro
     * in dropdown shopping cart with several products
     */
    @Test
    public void dropdownEuro() throws InterruptedException {
        double expected = Precision.round(0.78460002 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cart-total")).click();
        Thread.sleep(1000);
        String euro = driver.findElement(By.xpath("//td[strong='Total']/following-sibling::td")).getText();
        double actual = Double.parseDouble(euro.substring(0,euro.length()-1).replaceAll(",", ""));
        Assert.assertEquals(actual, expected, "Not equals");
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Pound
     * in dropdown shopping cart with several products
     */
    @Test
    public void dropdownPound() throws InterruptedException {
        double expected = Precision.round(0.61250001 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cart-total")).click();
        Thread.sleep(1000);
        double actual = Double.parseDouble(driver.findElement(By.xpath("//td[strong='Total']/following-sibling::td"))
                .getText().substring(1).replaceAll(",", ""));
        Assert.assertEquals(actual, expected, "Not equals");
    }

}
