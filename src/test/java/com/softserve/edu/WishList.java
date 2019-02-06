package com.softserve.edu;

import com.softserve.util.Login;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * This tests checks whether the price of a product changes correctly with a currency change
 * In the wish-list with one product
 */
public class WishList {

    private WebDriver driver;
    private double usd;
    private Login login = new Login();


    @BeforeClass
    public void beforeMethod() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/upload/");
        Thread.sleep(1000);
        login.login(driver);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img[src*='logo.png']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='product-thumb transition']//a[text()='MacBook']/../../.." +
                "//button[@data-original-title='Add to Wish List']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='USD']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("wishlist-total")).click();
        Thread.sleep(1000);
        usd = Double.parseDouble(driver.findElement(By.className("price")).getText().substring(1));
    }

    @AfterClass
    public void afterTest(){
        driver.findElement(By.xpath("//a[contains(@href,'remove=43')]")).click();
        driver.quit();
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Euro
     * in wish-list with one product
     */
    @Test
    public void euro () throws InterruptedException {
        double expected = Precision.round(0.78460002 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='EUR']")).click();
        Thread.sleep(1000);
        String price = driver.findElement(By.className("price")).getText();
        Thread.sleep(1000);
        double actual = Double.parseDouble(price.substring(0,price.length()-1));
        Assert.assertEquals(actual, expected, "Not equals");
    }

    /**
     * This test checks whether the price of a product changes correctly with the change of currency in Pound
     * in wish-list with one product
     */
    @Test
    public void pound () throws InterruptedException {
        double expected = Precision.round(0.61250001 * usd,2);
        driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".currency-select.btn.btn-link.btn-block[name='GBP']")).click();
        Thread.sleep(1000);
        String price = driver.findElement(By.className("price")).getText();
        Thread.sleep(1000);
        double actual = Double.parseDouble(price.substring(1));
        Assert.assertEquals(actual, expected, "Not equals");
    }


}
